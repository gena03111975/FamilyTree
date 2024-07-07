package FamilyTree;

import java.io.Serializable;
import java.util.*;
//import Human.HumanIterator;
import Human.HumanComparatorbyAmountOfChildren;

public class FamilyTree<E extends FamilyMember<E>> implements Serializable, Iterable<E> {
    private final List<E> listOfFamily;

    public FamilyTree(){
        listOfFamily = new ArrayList<>();
    }

    public FamilyTree(List<E> listOfFamily) {
        this.listOfFamily = listOfFamily;
    }

    public void addHumantoTree(E human) {
        if (!listOfFamily.contains(human)){
            listOfFamily.add(human);
            addHumantoChildListofParents(human);
            makeHumanaParentofChildList(human);
        }
    }

    private void makeHumanaParentofChildList(E human) {
        for(FamilyMember child: human.getChildrensList()){
            child.addParentstoFamilyMember(human);
        }
    }

    private void addHumantoChildListofParents(E human) {
        for(FamilyMember parent: human.getParentsofFamilyMember()){
            parent.addChildrentoFamilyMember(human);
        }
    }
    public E getbyId(Integer id) {
        for (E member: listOfFamily){
            if (member.getId().equals(id)){
                return member;
            }
        }
        System.out.println("Члена семьи с таким id нет");
        return null;
    }

    public List<E> getListOfFamily() {
        return listOfFamily;
    }

    public void sortByName(){
        //Collections.sort(listOfFamily);
        //sort(listOfFamily);
        listOfFamily.sort(null);
    }

    public void sortByAmountOfChildren(){
        listOfFamily.sort(new HumanComparatorbyAmountOfChildren<>());
    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном дереве сейчас: ");
        sb.append(listOfFamily.size()).append(" Чел."+"\n");
        for (E human: listOfFamily) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    //    @Override
//    public Iterator<Human> iterator() {
//        return new HumanIterator(this) ;
//    }
    @Override
    public Iterator<E> iterator() {
        return listOfFamily.iterator() ;
    }
}