public class CustomDisplayImpl extends DisplayImpl {
  private String leader, core, trailor;

  public CustomDisplayImpl(String leader, String core, String trailor) {
    this.leader = leader;
    this.core = core;
    this.trailor = trailor;
  }

  public void rawOpen() {
    System.out.print(leader);
  }

  public void rawPrint() {
    System.out.print(core);
  }

  public void rawClose() {
    System.out.println(trailor);
  }
}
