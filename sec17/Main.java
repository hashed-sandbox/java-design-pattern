public class Main {
  public static void main(String[] args) {
    NumberGenerator generator = new IncrementalNumberGenerator(1, 35, 2);
    Observer observer1 = new DigitObserver();
    Observer observer2 = new SumObserver();
    Observer observer3 = new GraphObserver();
    generator.addObserver(observer1);
    generator.addObserver(observer2);
    generator.addObserver(observer3);
    generator.execute();
  }
}
