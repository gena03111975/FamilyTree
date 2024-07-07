package HumanBuilder;

import FamilyTree.FamilyMember;

import java.util.Comparator;

public class HumanComparatorbyAmountOfChildren<E extends FamilyMember> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getChildrensList().size()-o2.getChildrensList().size();
    }
}