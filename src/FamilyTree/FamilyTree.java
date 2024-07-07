package FamilyTree;

import java.io.Serializable;
import java.util.*;
import Human.Human;
//import Human.HumanIterator;
import Human.HumanComparatorbyAmountOfChildren;

import static java.util.Collections.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> ListOfFamily;

    public FamilyTree(){
        ListOfFamily = new ArrayList<>();
    }

    public FamilyTree(List<Human> listOfFamily) {
        this.ListOfFamily = listOfFamily;
    }

    public void addHumantoTree(Human human) {
        if (!ListOfFamily.contains(human)){
            ListOfFamily.add(human);
            addHumantoChildListofParents(human);
            makeHumanaParentofChildList(human);
        }
    }

    private boolean makeHumanaParentofChildList(Human human) {
        for(Human child: human.getHumansChildrenList()){
            child.addParentstoHuman(human);
        }
        return true;
    }

    private void addHumantoChildListofParents(Human human) {
        for(Human parent: human.getParentsofHuman()){
            parent.addChildrentoHuman(human);
        }
    }
    public Human getbyId(Integer id) {
        for (Human member: ListOfFamily){
            if (member.getId()==id){
                return member;
            }
        }
        System.out.println("Члена семьи с таким id нет");
        return null;
    }

    public List<Human> getListOfFamily() {
        return ListOfFamily;
    }

    public void sortByName(){
        Collections.sort(ListOfFamily);
        //sort(ListOfFamily);
        //ListOfFamily.sort(null);
    }

    public void sortByAmountOfChildren(){
        ListOfFamily.sort(new HumanComparatorbyAmountOfChildren());
    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном дереве сейчас: ");
        sb.append(ListOfFamily.size()).append(" Чел."+"\n");
        for (Human human: ListOfFamily) {
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
    public Iterator<Human> iterator() {
        return ListOfFamily.iterator() ;
    }
}