public class TicketMaker {
  // Singleton
  private static TicketMaker maker = new TicketMaker();

  private int ticket = 1000;

  private TicketMaker() {}

  public static TicketMaker getInstance() {
    return maker;
  }

  public synchronized int getNextTicketNumber() {
    return ticket++;
  }
}
