import FamilyTree.FamilyTree;
import FamilyTreeService.FamilyTreeService;
import Human.Human;
import Human.Gender;
import Writer.FileHandler;

import java.io.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FamilyTree humanTree = new FamilyTree();
        FamilyTreeService service = new FamilyTreeService();

        Human human1 = service.addToTree( "Иван", Gender.Male, LocalDate.of(1928, 5, 15));
        Human human2 = service.addToTree("Мария", Gender.Female, LocalDate.of(1929, 10, 13));
        Human human3 = service.addToTree("Сергей", Gender.Male, LocalDate.of(1957, 5, 15), human1, human2);
        Human human4 = service.addToTree("Ольга", Gender.Male, LocalDate.of(1956, 4, 9));
        Human human5 = service.addToTree("Федор", Gender.Male, LocalDate.of(1984, 7, 9), human3,human4);
        Human human6 = service.addToTree("Светлана", Gender.Female, LocalDate.of(1985, 3, 8),human3,human4);
        Human human7 = service.addToTree("Василий", Gender.Male, LocalDate.of(1988, 12, 12),human3,human4);
        Human human8 = service.addToTree("Олег", Gender.Male, LocalDate.of(1985, 12, 12));
        Human human9 = service.addToTree("Елена", Gender.Female, LocalDate.of(2010, 1, 30));

        human1.setDod(LocalDate.of(2013, 10, 19));
        human6.addSpouse(human8);
        human6.addChildrentoHuman(human9);


//        service.sortByName();
//        System.out.println(service.getFamilyTreeInfo());

        service.sortByAmountOfChildren();
        System.out.println(service.getFamilyTreeInfo());

        FileHandler newFileHandler = new FileHandler();
        if (newFileHandler.writeObjecttoFile(service.newFamilyTree)){
            System.out.println("Объект успешно сериализован в файл ");
        }
        FamilyTree seializedFamilyTree = (FamilyTree) newFileHandler.readObjectfromFile();
        System.out.println("Объект успешно десериализован из файла");
        //System.out.println(seializedFamilyTree);

    }
}