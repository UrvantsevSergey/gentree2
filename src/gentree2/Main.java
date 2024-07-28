import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Main implements Serializable{
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);
    }
    public static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();
        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1990, 1, 1));
        Human masha = new Human("Маша", Gender.Female, LocalDate.of(1990, 1, 1));
        Human oleg = new Human("Олег", Gender.Male, LocalDate.of(2010, 1, 1), masha, ivan);
        tree.addHuman(ivan);
        tree.addHuman(masha);
        tree.addHuman(oleg);
        

        Writer writer = new Writer(tree);
        try {
            writer.saveinFile("family_tree.csv");
            System.out.println("Family tree saved to file.");

            writer.readFromFile("family_tree.csv");
            System.out.println("Family tree loaded from file.");

            FamilyTree loadtree = writer.getFamilyTree();
            System.out.println(loadtree);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tree;
    
    }
}
