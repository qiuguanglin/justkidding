package app.lettertwister;

import app.ErrorCode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LetterTwisterTest {

    private LetterTwister lt;

    @Before
    public void setUp() {
        lt = new LetterTwister();
    }

    @Test
    public void twoNumberTest() throws NumberMappingException {
        List<String> result = lt.allLetterCombinations(new int[]{2, 3});
        assertEquals(result.size(), 9);
        assertEquals(result.toString(), "[AD, AE, AF, BD, BE, BF, CD, CE, CF]");
    }

    @Test
    public void oneNumberTest() throws NumberMappingException {
        List<String> result = lt.allLetterCombinations(new int[]{9});
        assertEquals(result.size(), 4);
        assertEquals(result.toString(), "[W , X , Y , Z ]");
    }

    @Test
    public void oneNumberHasNoDigitsTest() throws NumberMappingException {
        List<String> result = lt.allLetterCombinations(new int[]{1, 5});
        assertEquals(result.size(), 0);
    }

    @Test
    public void numberNotExistTest() {
        NumberMappingException throwable = null;
        try {
            lt.allLetterCombinations(new int[]{10});
        } catch (NumberMappingException e) {
            throwable = e;
        }
        assertNotNull(throwable);
        assertEquals(throwable.getErrCode(), ErrorCode.NUMBER_MAPPING_EXCEPTION);
    }
}