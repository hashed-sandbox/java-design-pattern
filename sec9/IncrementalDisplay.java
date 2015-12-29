public class IncrementalDisplay extends CountDisplay {
  public IncrementalDisplay(DisplayImpl impl) {
    super(impl);
  }

  public void incrementalDisplay(int times) {
    for (int i = 0; i < times; i++) {
      multiDisplay(i);
    }
  }
}
