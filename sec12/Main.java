public class Main {
  public static void main(String[] args) {
    Display d1 = new StringDisplay("Hello, world.");
    Display d2 = new UpDownBorder(d1, '-');
    Display d3 = new SideBorder(d2, '*');
    d1.show();
    d2.show();
    d3.show();

    Display d4
      = new FullBorder(
          new UpDownBorder(
            new SideBorder(
              new UpDownBorder(
                new SideBorder(
                  new StringDisplay("Hello."), '*'
                ), '='
              ), '|'
            ), '/'
          )
        );
    d4.show();

    MultiStringDisplay md = new MultiStringDisplay();
    md.add("Good morning.");
    md.add("Good afternoon.");
    md.add("Good night.");
    md.show();

    Display d5 = new SideBorder(md, '#');
    Display d6 = new FullBorder(md);
    d5.show();
    d6.show();
  }
}
