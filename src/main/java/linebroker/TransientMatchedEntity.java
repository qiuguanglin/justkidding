package linebroker;

import java.util.ArrayList;
import java.util.List;

public final class TransientMatchedEntity {
    private int pos;
    private List<String> buffer;

    public TransientMatchedEntity() {
        this.buffer = new ArrayList();
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public List<String> getBuffer() {
        return buffer;
    }

    @Override
    public String toString() {
        return "pos:" + pos + "," + buffer.toString();
    }
}
