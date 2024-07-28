import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        this.id = (int) IdGenerator.generateId();
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }
    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }
    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, gender, birthDate, null, mother, father);
    }
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean addParrents(Human parrent) {
        if (parrent.getGender().equals(Gender.Male)) {
            setFather(parrent);
        }
        else if (parrent.getGender().equals(Gender.Female)) {
            setMother(parrent);
        }
        return true;
    }
    public List<Human> getParrents() {
        List<Human> parrents = new ArrayList<>();
        if (father != null) {
            parrents.add(getFather());
        }
        if (mother != null) {
            parrents.add(getMother());
        }
        return parrents;
    }
    private void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender() {
        return gender;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public Human getFather() {
        return father;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getMother() {
        return mother;
    }
    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate startDate, LocalDate endDate) {
        return Period.between(startDate, endDate).getYears();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public LocalDate getDeathDate() {
        return deathDate;
    }
    public List<Human> getChildren() {
        return children;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(gender);
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public String getMotherInfo() {
        String res = "mother: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        }
        else {
            res += "unknown";
        }
        return res;
    }
    public String getFatherInfo() {
        String res = "father: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        }
        else {
            res += "unknown";
        }
        return res;
    }
    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("children: ");
        if (children.size() != 0) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        } else {
            sb.append("none");
        }
        return sb.toString();
    }
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human other = (Human) obj;
        return other.getId() == getId();
    }

}