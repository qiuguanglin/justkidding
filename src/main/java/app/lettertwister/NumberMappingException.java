package app.lettertwister;

public class NumberMappingException extends Throwable {
    private int errCode;
    public NumberMappingException(String msg, int errCode){super(msg);this.errCode = errCode;}

    public int getErrCode() {
        return errCode;
    }
}
