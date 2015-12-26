import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {
  public void readFromFile(String filename) throws IOException {
    load(new FileReader(filename));
  }
  public void writeToFile(String filename) throws IOException {
    store(new FileWriter(filename), "written by FileProperties");
  }
  public void setValue(String key, String value) {
    setProperty(key, value);
  }
  public String getValue(String key) {
    return getProperty(key);
  }
}
