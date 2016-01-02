public class BigString {
  private static BigCharFactory factory = BigCharFactory.getInstance();
  private BigChar[] bigchars;

  public BigString(String string) {
    initBigChars(string, true);
  }

  public BigString(String string, boolean shared) {
    initBigChars(string, shared);
  }

  private void initBigChars(String string, boolean shared) {
    bigchars = new BigChar[string.length()];
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i] = (shared) ? factory.getBigChar(string.charAt(i))
                             : new BigChar(string.charAt(i));
    }
  }

  public void print() {
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i].print();
    }
  }
}
