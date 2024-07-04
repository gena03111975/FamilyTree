package Writer;

import java.io.*;

public interface Writable extends Serializable {

    boolean writeObjecttoFile(Object object) throws IOException;

    Object readObjectfromFile() throws IOException, ClassNotFoundException;
}
