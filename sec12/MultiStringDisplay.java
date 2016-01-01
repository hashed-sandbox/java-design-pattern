import java.util.ArrayList;

public class MultiStringDisplay extends Display {
  private ArrayList<String> str_list = new ArrayList<String>();
  private int max_columns = 0;

  public void add(String str) {
    int columns = str.getBytes().length;
    if (max_columns < columns) {
      max_columns = columns;
    }
    str_list.add(str);
  }

  public int getColumns() {
    return max_columns;
  }

  public int getRows() {
    return str_list.size();
  }

  public String getRowText(int row) {
    return str_list.get(row);
  }
}
