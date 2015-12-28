public abstract class Builder {
  private boolean hasTitle = false;

  public void makeTitle(String title) {
    if (!hasTitle) {
      buildTitle(title);
      hasTitle = true;
    }
  }

  public void makeString(String str) {
    if (hasTitle) {
      buildString(str);
    }
  }

  public void makeItems(String[] items) {
    if (hasTitle) {
      buildItems(items);
    }
  }

  public void close() {
    if (hasTitle) {
      buildDone();
    }
  }

  protected abstract void buildTitle(String title);
  protected abstract void buildString(String str);
  protected abstract void buildItems(String[] items);
  protected abstract void buildDone();
}
