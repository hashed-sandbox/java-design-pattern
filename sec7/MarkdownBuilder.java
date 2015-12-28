import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MarkdownBuilder extends Builder {
  private String filename;
  private PrintWriter writer;

  public void buildTitle(String title) {
    filename = title + ".md";
    try {
      writer = new PrintWriter(new FileWriter(filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
    writer.println("# " + title);
    writer.println("");
  }

  public void buildString(String str) {
    writer.println(str);
    writer.println("");
  }

  public void buildItems(String[] items) {
    for (int i = 0; i < items.length; i++) {
      writer.println("* " + items[i]);
    }
    writer.println("");
  }

  public void buildDone() {
    writer.close();
  }

  public String getResult() {
    return filename;
  }
}
