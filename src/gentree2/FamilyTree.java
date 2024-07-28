import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private final List<Human> famtree;

    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(List<Human> famtree) {
        this.famtree = famtree;
    }
    public boolean addHuman(Human human) {
        if (human == null){
            return false;
        }
        if (!famtree.contains(human)) {
            famtree.add(human);
            addToParrents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }
    public void addToParrents(Human human) {
        for (Human parrent: human.getParrents()) {
            parrent.addChild(human);
        }
    }
    public void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParrents(human);
        }
    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family Tree: \n");
        sb.append(famtree.size());
        for (Human human : famtree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
