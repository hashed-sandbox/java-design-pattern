public class FullBorder extends Border {
  public FullBorder(Display display) {
    super(display);
  }

  public int getColumns() {
    return 1 + display.getColumns() + 1;
  }

  public int getRows() {
    return 1 + display.getRows() + 1;
  }

  public String getRowText(int row) {
    if (row == 0) {
      return "+" + makeLine('-', display.getColumns()) + "+";
    } else if (row == display.getRows() + 1) {
      return "+" + makeLine('-', display.getColumns()) + "+";
    } else {
      return "|" + display.getRowText(row - 1) + padding(row - 1) + "|";
    }
  }
}
