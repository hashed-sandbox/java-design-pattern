public class SumObserver implements Observer {
  private int sum = 0;

  public void update(NumberGenerator generator) {
    sum += generator.getNumber();
    System.out.println("SumObserver:" + sum);
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
    }
  }
}
