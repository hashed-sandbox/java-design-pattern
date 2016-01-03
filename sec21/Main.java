public class Main {
  public static void main(String[] args) {
    Printable p = new PrinterProxy("Alice", "Printer");
    System.out.println("The current name is " + p.getPrinterName());
    p.setPrinterName("Bob");
    System.out.println("The current name is " + p.getPrinterName());
    p.print("Hello, world.");
  }
}
