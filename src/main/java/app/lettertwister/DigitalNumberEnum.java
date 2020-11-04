package app.lettertwister;

public enum DigitalNumberEnum {
    ZERO(0, new char[]{}),
    ONE(1, new char[]{}),
    TWO(2, new char[]{'A', 'B', 'C'}),
    THREE(3, new char[]{'D', 'E', 'F'}),
    FORE(4, new char[]{'G', 'H', 'I'}),
    FIVE(5, new char[]{'J', 'K', 'L'}),
    SIX(6, new char[]{'M', 'N', 'O'}),
    SEVEN(7, new char[]{'P', 'Q', 'R', 'S'}),
    EIGHT(8, new char[]{'T', 'U', 'V'}),
    NIGHT(9, new char[]{'W', 'X', 'Y', 'Z'}),
    DUMMY(-1, new char[]{' '});

    private int number;
    private char[] letters;

    DigitalNumberEnum(int number, char[] letters) {
        this.number = number;
        this.letters = letters;
    }

    public int getNumber() {
        return this.number;
    }

    public char[] getLetters() {
        return this.letters;
    }

}
