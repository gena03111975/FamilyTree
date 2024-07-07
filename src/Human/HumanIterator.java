package Human;

import FamilyTree.FamilyTree;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class HumanIterator implements Iterator<Human> {
    private int currentId;
    private List<Human> listOfFamily;

    public HumanIterator(FamilyTree familyTree) {
        this.listOfFamily = familyTree.getListOfFamily();
        this.currentId=0;
    }

    @Override
    public boolean hasNext() {
        return currentId < listOfFamily.size();
    }

    @Override
    public Human next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        return listOfFamily.get(currentId++);
    }
}