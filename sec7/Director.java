public class Director {
  private Builder builder;

  public Director(Builder builder) {
    this.builder = builder;
  }

  public void construct() {
    builder.makeTitle("Greeting");
    builder.makeString("Moning to Afternoon");
    builder.makeItems(new String[] {
      "Good Morning.",
      "Good Afternoon."
    });
    builder.makeString("Evening");
    builder.makeItems(new String[] {
      "Good Evening.",
      "Good Night.",
      "Good Bye."
    });
    builder.close();
  }
}
