public class Triple {
  // singleton pattern
  private static Triple[] instances;

  static {
    instances = new Triple[3];
    for (int i = 0; i < instances.length; i++) {
      instances[i] = new Triple(i);
    }
  }

  // instance variable
  private int id;

  // constructor
  private Triple(int id) {
    this.id = id;
  }

  // class method
  public static Triple getInstance(int id) {
    return instances[id];
  }

  // instance methods
  public int getID() {
    return id;
  }
}
