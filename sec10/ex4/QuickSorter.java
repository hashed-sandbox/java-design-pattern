public class QuickSorter implements Sorter {
  private Comparable[] data;

  public void sort(Comparable[] data) {
    this.data = data;
    quicksort(0, data.length - 1);
  }

  private void quicksort(int left, int right) {
    int l = left, r = right;
    Comparable key = data[(left + right) / 2];
    Comparable tmp;

    while (l <= r) {
      while (data[l].compareTo(key) < 0) { l++; }
      while (data[r].compareTo(key) > 0) { r--; }
      if (l <= r) { swap(l, r); l++; r--; }
    }

    if (left < r)  { quicksort(left, r); }
    if (l < right) { quicksort(l, right); }
  }

  private void swap(int i, int j) {
    Comparable tmp = data[i];
    data[i] = data[j];
    data[j] = tmp;
  }
}
