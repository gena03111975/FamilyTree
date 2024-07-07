package Dogs;

import java.util.Comparator;

public class DogsComparatorbyAmountOfPuppies implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getDogsPuppiesList().size()-o2.getDogsPuppiesList().size();
    }
}