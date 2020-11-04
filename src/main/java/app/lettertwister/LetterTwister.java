package app.lettertwister;

import app.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public final class LetterTwister {
    public List<String> allLetterCombinations(int[] numbers) throws NumberMappingException {
        if (numbers.length == 1)
            return allLetterCombinations(numbers[0]);

        int num1, num2;
        try {
            num1 = numbers[0];
            num2 = numbers[1];
        } catch (Exception e) {
            throw new NumberMappingException(e.getMessage(), ErrorCode.NUMBER_MAPPING_EXCEPTION);
        }
        return allLetterCombinations(num1, num2);
    }

    private List<String> allLetterCombinations(int number) throws NumberMappingException {
        DigitalNumberEnum digitalNumberEnum = DigitalNumberMapper.NUMBER_MAP.get(number);
        if (digitalNumberEnum == null)
            throw new NumberMappingException("invalid number " + number, ErrorCode.NUMBER_MAPPING_EXCEPTION);

        return doLetterTwister(digitalNumberEnum, DigitalNumberEnum.DUMMY);
    }

    private List<String> allLetterCombinations(int num1, int num2) throws NumberMappingException {
        DigitalNumberEnum digitalNumberEnum1 = DigitalNumberMapper.NUMBER_MAP.get(num1);
        DigitalNumberEnum digitalNumberEnum2 = DigitalNumberMapper.NUMBER_MAP.get(num2);
        if (digitalNumberEnum1 == null || digitalNumberEnum2 == null)
            throw new NumberMappingException("invalid number(s)", ErrorCode.NUMBER_MAPPING_EXCEPTION);

        return doLetterTwister(digitalNumberEnum1, digitalNumberEnum2);
    }

    private List<String> doLetterTwister(DigitalNumberEnum digitalEnum1, DigitalNumberEnum digitalEnum2) {
        List<String> result = new ArrayList();
        char[] letterList1 = digitalEnum1.getLetters();
        char[] letterList2 = digitalEnum2.getLetters();
        for (char c1 : letterList1) {
            for (char c2 : letterList2) {
                result.add(c1 + "" + c2);
            }
        }
        return result;
    }
}
