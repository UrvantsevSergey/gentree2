import java.io.IOException;

public interface Saveable {
    public void saveinFile(String fileName) throws IOException;
    public void readFromFile(String fileName) throws IOException, ClassNotFoundException;
}