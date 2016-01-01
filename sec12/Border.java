public abstract class Border extends Display {
  protected Display display;

  protected Border(Display display) {
    this.display = display;
  }

  protected String makeLine(char ch, int count) {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < count; i++) {
      buf.append(ch);
    }
    return buf.toString();
  }

  protected final String padding(int row) {
    int text_width  = display.getRowText(row).getBytes().length;
    int field_width = display.getColumns();

    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < field_width - text_width; i++) {
      buf.append(' ');
    }
    return buf.toString();
  }
}
