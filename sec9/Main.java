public class Main {
  public static void main(String[] args) {
    Display d1
      = new Display(new StringDisplayImpl("Hello, World."));
    RandomDisplay d2
      = new RandomDisplay(new StringDisplayImpl("Hello, Universe."));
    RandomDisplay d3
      = new RandomDisplay(new FileDisplayImpl("DisplayImpl.java"));
    IncrementalDisplay d4
      = new IncrementalDisplay(new CustomDisplayImpl("|", "##", "-"));

    d1.display();
    d2.randomDisplay(10);
    d3.randomDisplay(5);
    d4.incrementalDisplay(6);
  }
}
