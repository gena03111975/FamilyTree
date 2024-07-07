package FamilyTreeService;

import FamilyTree.FamilyTree;
import Human.Gender;
import Human.Human;
import HumanBuilder.HumanBuilder;

import java.time.LocalDate;

public class FamilyTreeService {
    public HumanBuilder newHumanBuilder;
    public FamilyTree newFamilyTree;

    public FamilyTreeService() {
        newHumanBuilder = new HumanBuilder();
        newFamilyTree = new FamilyTree();
    }

    public Human addToTree(String name, Gender gender, LocalDate dateOfBirth){
        Human human = newHumanBuilder.build(name, gender, dateOfBirth);
        newFamilyTree.addHumantoTree(human);
        return human;
    }

    public Human addToTree(String name, Gender gender, LocalDate dateOfBirth, Human father, Human mother) {
        Human human = newHumanBuilder.build(name, gender, dateOfBirth, father, mother);
        newFamilyTree.addHumantoTree(human);
        return human;
    }
    public String getFamilyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");
        for (Human human: newFamilyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByName(){
        newFamilyTree.sortByName();
    }
    public void sortByAmountOfChildren(){
        newFamilyTree.sortByAmountOfChildren();
    }
}