package HumanBuilder;
import Human.Gender;
import Human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable {
    private int id;

    public Human build(String name, Gender gender, LocalDate dateOfBirth){
        return new Human(id++, name, gender, dateOfBirth);
    };

    public Human build(String name, Gender gender, LocalDate dateOfBirth, Human father, Human mother){
        return new Human(id++, name, gender, dateOfBirth, father, mother);
    };

    public int gethumanId() {
        return this.id;
    }
}
