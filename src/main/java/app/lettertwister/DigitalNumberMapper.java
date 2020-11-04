package app.lettertwister;

import java.util.HashMap;
import java.util.Map;

public final class DigitalNumberMapper {
    public static Map<Integer, DigitalNumberEnum> NUMBER_MAP = new HashMap() ;
    static{
        NUMBER_MAP.put(0, DigitalNumberEnum.ZERO);
        NUMBER_MAP.put(1, DigitalNumberEnum.ONE);
        NUMBER_MAP.put(2, DigitalNumberEnum.TWO);
        NUMBER_MAP.put(3, DigitalNumberEnum.THREE);
        NUMBER_MAP.put(4, DigitalNumberEnum.FORE);
        NUMBER_MAP.put(5, DigitalNumberEnum.FIVE);
        NUMBER_MAP.put(6, DigitalNumberEnum.SIX);
        NUMBER_MAP.put(7, DigitalNumberEnum.SEVEN);
        NUMBER_MAP.put(8, DigitalNumberEnum.EIGHT);
        NUMBER_MAP.put(9, DigitalNumberEnum.NIGHT);
    }



}