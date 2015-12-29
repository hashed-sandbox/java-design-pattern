package tablefactory;

import factory.Item;
import factory.Tray;
import java.util.Iterator;

public class TableTray extends Tray {
  public TableTray(String caption) {
    super(caption);
  }

  public String makeHTML() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("<td>");
    buffer.append("<table width=\"100%\" border=\"1\">");
    buffer.append("<tr>");
    buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"" + tray.size() + "\">");
    buffer.append("<b>" + caption + "</b></td>");
    buffer.append("</tr>\n");

    buffer.append("<tr>");
    Iterator it = tray.iterator();
    while (it.hasNext()) {
      Item item = (Item)it.next();
      buffer.append(item.makeHTML());
    }
    buffer.append("</tr>\n");

    buffer.append("</table>");
    buffer.append("</td>");
    return buffer.toString();
  }
}
