package linebroker;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LineBreakerTest {
    LineBreaker lb;

    @Before
    public void setUp() {
        lb = new LineBreaker();
    }

    @Test
    public void compositeWordTest() throws InvalidLineException {
        String[] dictionary = {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man", "go", "mango", "and"};
        String lineSample1 = "ilikesamsungmobile";

        List<String> result1 = lb.brokenLines(lineSample1, dictionary);
        assertEquals(result1.size(), 2);
        assertTrue(result1.stream().anyMatch(line -> line.equals("i like sam sung mobile")));
        assertTrue(result1.stream().anyMatch(line -> line.equals("i like samsung mobile")));
    }

    @Test
    public void multipleCompositeWordTest() throws InvalidLineException {
        String[] dictionary = {"i", "like", "ice", "cream", "man", "go", "mango", "and", "durian", "but", "pie", "durianpie", "not"};
        String lineSample = "ilikemangoandicecreambutnotdurianpie";
        List<String> result = lb.brokenLines(lineSample, dictionary);

        assertEquals(result.size(), 4);
        assertTrue(result.stream().anyMatch(line -> line.equals("i like mango and ice cream but not durianpie")));
        assertTrue(result.stream().anyMatch(line -> line.equals("i like mango and ice cream but not durian pie")));
        assertTrue(result.stream().anyMatch(line -> line.equals("i like man go and ice cream but not durian pie")));
        assertTrue(result.stream().anyMatch(line -> line.equals("i like man go and ice cream but not durianpie")));
    }

    @Test
    public void prefixCompositeWordTest() throws InvalidLineException {
        String[] dictionary = {"phone", "convenient", "smart", "is", "smartphone"};
        String lineSample = "smartphoneisconvenient";
        List<String> result = lb.brokenLines(lineSample, dictionary);

        assertEquals(result.size(), 2);
        assertTrue(result.stream().anyMatch(line -> line.equals("smart phone is convenient")));
        assertTrue(result.stream().anyMatch(line -> line.equals("smartphone is convenient")));
    }

    @Test
    public void containedWordNotInDictionaryTest() {
        InvalidLineException throwable = null;
        try {
            String[] dictionary = {"time", "pain", "erase", "the"};
            String lineSample = "timeaggravatethepain";
            lb.brokenLines(lineSample, dictionary);
        } catch (InvalidLineException e) {
            throwable = e;
        }
        assertNotNull(throwable);
        assertEquals(throwable.getErrCode(), ErrorCode.INVALID_USER_INPUT);
    }

    @Test
    public void containedWordCaseNotMatchedTest() {
        InvalidLineException throwable = null;
        try {
            String[] dictionary = {"Time", "pain", "erase", "the"};
            String lineSample = "timeerasethepain";
            lb.brokenLines(lineSample, dictionary);
        } catch (InvalidLineException e) {
            throwable = e;
        }
        assertNotNull(throwable);
        assertEquals(throwable.getErrCode(), ErrorCode.INVALID_USER_INPUT);
    }
}