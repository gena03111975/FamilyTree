package Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


public class Human implements Serializable, Comparable<Human> {
    private int id;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private Human father, mother;
    private Human spouse;
    private final List<Human> childrenList;
    private final List<Human> parentsList;


    public Human(int id, String name, Gender gender, LocalDate dob, LocalDate dod, Human father, Human mother){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob=dob;
        this.father= father;
        this.mother=mother;
        childrenList = new ArrayList<>();
        parentsList = new ArrayList<>();

        if (father != null) {
            father.addChildrentoHuman(this);
        }
        if (mother != null) {
            mother.addChildrentoHuman(this);
        }
    }

    public Human(int id, String name, Gender gender, LocalDate dob, Human father, Human mother) {
        this(id, name, gender, dob,null, father, mother);
    }

    public Human(int id, String name, Gender gender, LocalDate dob) {
        this(id, name, gender, dob, null, null, null);
    }

    //методы добавления и получения списка детей у человека
    public void addChildrentoHuman(Human child){
        if(!childrenList.contains(child)){
            childrenList.add(child);
            if(!parentsList.contains(this)) {
                child.addParentstoHuman(this);
            }
        }
    }
    public List<Human> getHumansChildrenList()
    {
        return this.childrenList;
    }
    //методы добавления и получения списка родителей у человека
    public void addParentstoHuman(Human parent) {
        if(!this.parentsList.contains(parent)){
            this.parentsList.add(parent);
        }
    }

    public List<Human> getParentsofHuman(){
        return this.parentsList;
    }


    //методы добавления и получения супруга(и) у человека
    public void addSpouse (Human human) {
        spouse=human;
    }

    public Human getSpouse () {
        return this.spouse;
    }

    //метод добавления и получения id у человека
    public int getId(){
        return id;
    }

    //геттеры и сеттеры
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDod(LocalDate dod) {
        this.dod = dod;
    }
    public LocalDate getDod() {
        return dod;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender() {
        return gender;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getMother() {
        return mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public Human getFather() {
        return father;
    }


    //переписываем метод equals
    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Human other = (Human) obj;
        return Objects.equals(this.getId(), other.getId());

    }

    //переписываем метод toString
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ");
        sb.append(id).append("\n");
        if (name != null) {
            sb.append(name).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Пол: ");
        if (gender != null) {
            sb.append(gender).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Дата рождения: ");
        if (dob != null) {
            sb.append(dob).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Дата смерти: ");
        if (dod != null) {
            sb.append(dod).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Отец: ");
        if (getFather() != null && getFather().getName()!=null) {
            sb.append("id=").append(getFather().getId()).append(",").append(getFather().getName()).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Мать: ");
        if (getMother() != null && getMother().getName()!=null) {
            sb.append("id=").append(getMother().getId()).append(",").append(getMother().getName()).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Супруг(а): ");
        if (getSpouse() != null && getSpouse().getName()!=null) {
            sb.append(getSpouse().getName()).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Дети: "+"\n");
        if (childrenList != null && !childrenList.isEmpty()) {
            for (Human unit : childrenList) {
                sb.append("id=").append(unit.getId()).append(",").append(unit.getName()).append("\n");
            }
        }
        else{
            sb.append("____").append("\n");
        }
        return sb.toString();
    }


    @Override
    public int compareTo(Human anotherHuman) {
        return this.name.compareTo(anotherHuman.name);
    }
}
