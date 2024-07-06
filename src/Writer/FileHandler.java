package Writer;

import java.io.*;

public class FileHandler implements Writable {
    String fileName = "FamilyTree.out";

    @Override
    public boolean writeObjecttoFile(Object object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        return true;
    }

    @Override
    public Object readObjectfromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));

        return objectInputStream.readObject();
    }
}