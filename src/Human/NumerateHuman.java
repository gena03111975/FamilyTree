package Human;

import java.io.Serializable;

public class NumerateHuman implements Serializable {
    private int id;
    private static int humancount = 0;

    public NumerateHuman(){
        humancount++;
        id = humancount;
    }
    public int gethumanId() {
        return this.id;

    }
}
