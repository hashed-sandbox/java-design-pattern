import java.util.ArrayList;
import java.util.Iterator;

public class FileFindVisitor extends Visitor {
  private String ext;
  private ArrayList<File> founds = new ArrayList<File>();

  public FileFindVisitor(String ext) {
    this.ext = ext;
  }

  public void visit(File file) {
    if (file.getName().endsWith(ext)) {
      founds.add(file);
    }
  }

  public void visit(Directory directory) {
    Iterator<Entry> it = directory.iterator();
    while (it.hasNext()) {
      it.next().accept(this);
    }
  }

  public Iterator<File> getFoundFiles() {
    return founds.iterator();
  }
}
