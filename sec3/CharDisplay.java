public class CharDisplay extends AbstractDisplay {
  private char ch;
  public CharDisplay(char ch) {
    this.ch = ch;
  }
  void open() {
    System.out.print("<<");
  }
  void print() {
    System.out.print(ch);
  }
  void close() {
    System.out.println(">>");
  }
}
