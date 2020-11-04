package app.linebreaker;

import app.ErrorCode;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public final class LineBreaker {
    public List<String> brokenLines(String line, String[] words) throws InvalidLineException {
        List<TransientMatchedEntity> rawResult = doBreak(line, words);
        if (rawResult.isEmpty())
            throw new InvalidLineException("user input contains a word not found in the dictionary", ErrorCode.INVALID_USER_INPUT);

        List<String> result = rawResult.stream().map(TransientMatchedEntity::getBuffer)
                .map(bf -> String.join(" ", bf))
                .collect(Collectors.toList());
        return result;
    }

    private List<TransientMatchedEntity> doBreak(String line, String[] dictionary) {
        CopyOnWriteArrayList<TransientMatchedEntity> list = new CopyOnWriteArrayList<>();
        //initialize the container that maintains all possibilities
        for (String word : dictionary) {
            if (line.startsWith(word)) {
                TransientMatchedEntity tm = new TransientMatchedEntity();
                tm.setPos(word.length());
                tm.getBuffer().add(word);
                list.add(tm);
            }
        }

        while (true) {
            //if all possibilities are extracted then finish
            boolean isAllDone = list.stream().allMatch(tm -> tm.getPos() == line.length());
            if (isAllDone) break;

            Iterator<TransientMatchedEntity> it = list.iterator();
            while (it.hasNext()) {
                TransientMatchedEntity tm = it.next();
                if (tm.getPos() == line.length()) continue;

                for (String word : dictionary) {
                    if (line.startsWith(word, tm.getPos())) {
                        //found a word matched, reset the offset and add the matched word to buffer
                        TransientMatchedEntity newTm = new TransientMatchedEntity();
                        newTm.setPos(tm.getPos() + word.length());
                        newTm.getBuffer().addAll(tm.getBuffer());
                        newTm.getBuffer().add(word);
                        list.add(newTm);
                    }
                }
                list.remove(tm); //we don't want the used ones
            }
        }
        return list;
    }
}
