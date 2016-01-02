public class Main {
  private static BigString[] bsarray = new BigString[1000];

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage: java Main digits");
      System.out.println("Example: java Main 1212123");
      System.exit(0);
    }

    testAllocation(args[0], true);
    testAllocation(args[0], false);
  }

  private static void testAllocation(String string, boolean shared) {
    for (int i = 0; i < bsarray.length; i++) {
      bsarray[i] = new BigString(string, shared);
    }
    benchmark();
  }

  private static void benchmark() {
    Runtime.getRuntime().gc();
    long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    System.out.println(used);
  }
}
