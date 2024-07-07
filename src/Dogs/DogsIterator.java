package Dogs;

import FamilyTree.FamilyTree;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class DogsIterator implements Iterator<Dog> {
    private int currentId;
    private List<Dog> listOfFamily;

    public DogsIterator(FamilyTree familyTree) {
        this.listOfFamily = familyTree.getListOfFamily();
        this.currentId=0;
    }

    @Override
    public boolean hasNext() {
        return currentId < listOfFamily.size();
    }

    @Override
    public Dog next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        return listOfFamily.get(currentId++);
    }
}