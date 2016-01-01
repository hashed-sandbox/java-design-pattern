import java.util.ArrayList;
import java.util.Iterator;

public class ElementArrayList extends ArrayList<Entry> implements Element {
  public void accept(Visitor v) {
    Iterator<Entry> it = iterator();
    while(it.hasNext()) {
      it.next().accept(v);
    }
  }
}
