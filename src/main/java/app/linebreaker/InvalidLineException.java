package app.linebreaker;

public class InvalidLineException extends Throwable {
    private int errCode;

    public InvalidLineException(String msg, int errCode) {
        super(msg);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }
}
