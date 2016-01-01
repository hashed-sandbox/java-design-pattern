public class UpDownBorder extends Border {
  private char borderChar;

  public UpDownBorder(Display display, char ch) {
    super(display);
    this.borderChar = ch;
  }

  public int getColumns() {
    return display.getColumns();
  }

  public int getRows() {
    return 1 + display.getRows() + 1;
  }

  public String getRowText(int row) {
    if (row == 0 || row == display.getRows() + 1) {
      return makeLine(borderChar, display.getColumns());
    } else {
      return display.getRowText(row - 1);
    }
  }
}
