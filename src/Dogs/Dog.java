package Dogs;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Dog implements Serializable, Comparable<Dog> {
    private int id;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private Dog father, mother;
    private Dog spouse;
    private final List<Dog> puppiesList;
    private final List<Dog> parentsList;


    public Dog(int id, String name, Gender gender, LocalDate dob, LocalDate dod, Dog father, Dog mother){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob=dob;
        this.father= father;
        this.mother=mother;
        puppiesList = new ArrayList<>();
        parentsList = new ArrayList<>();

        if (father != null) {
            father.addPuppytoDog(this);
        }
        if (mother != null) {
            mother.addPuppytoDog(this);
        }
    }

    public Dog(int id, String name, Gender gender, LocalDate dob, Dog father, Dog mother) {
        this(id, name, gender, dob,null, father, mother);
    }

    public Dog(int id, String name, Gender gender, LocalDate dob) {
        this(id, name, gender, dob, null, null, null);
    }

    //методы добавления и получения списка детей у человека
    public void addPuppytoDog(Dog puppy){
        if(!puppiesList.contains(puppy)){
            puppiesList.add(puppy);
            if(!parentsList.contains(this)) {
                puppy.addParentstoDog(this);
            }
        }
    }
    public List<Dog> getDogsPuppiesList()
    {
        return this.puppiesList;
    }
    //методы добавления и получения списка родителей у человека
    public void addParentstoDog(Dog parent) {
        if(!this.parentsList.contains(parent)){
            this.parentsList.add(parent);
        }
    }

    public List<Dog> getParentsofDog(){
        return this.parentsList;
    }


    //методы добавления и получения супруга(и) у человека
    public void addSpouse (Dog dog) {
        spouse= dog;
    }

    public Dog getSpouse () {
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
    public void setMother(Dog mother) {
        this.mother = mother;
    }
    public Dog getMother() {
        return mother;
    }
    public void setFather(Dog father) {
        this.father = father;
    }
    public Dog getFather() {
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
        Dog other = (Dog) obj;
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
        if (puppiesList != null && !puppiesList.isEmpty()) {
            for (Dog unit : puppiesList) {
                sb.append("id=").append(unit.getId()).append(",").append(unit.getName()).append("\n");
            }
        }
        else{
            sb.append("____").append("\n");
        }
        return sb.toString();
    }


    @Override
    public int compareTo(Dog anotherDog) {
        return this.name.compareTo(anotherDog.name);
    }
}
