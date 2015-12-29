import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDisplayImpl extends DisplayImpl {
  private String filename;
  private RandomAccessFile file;

  public FileDisplayImpl(String filename) {
    this.filename = filename;
  }

  public void rawOpen() {
    try {
      file = new RandomAccessFile(filename, "r");
    } catch (FileNotFoundException e) {
      System.err.println(filename + " was not found.");
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
    printMarker("start");
  }

  public void rawPrint() {
    String line;
    try {
      while ((line = file.readLine()) != null) {
        System.out.println(line);
      }
      file.seek(0);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void rawClose() {
    printMarker("end");
    try {
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void printMarker(String comment) {
    System.out.println("### " + filename + " " + comment + " ###");
  }
}
