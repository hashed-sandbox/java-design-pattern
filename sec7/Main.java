public class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      usage();
      System.exit(0);
    }
    if (args[0].equals("plain")) {
      TextBuilder textbuilder = new TextBuilder();
      Director director = new Director(textbuilder);
      director.construct();
      String result = textbuilder.getResult();
      System.out.println(result);
    } else if (args[0].equals("html")) {
      HTMLBuilder htmlbuider = new HTMLBuilder();
      Director director = new Director(htmlbuider);
      director.construct();
      String filename = htmlbuider.getResult();
      System.out.println(filename + " has been built.");
    } else if (args[0].equals("markdown")) {
      MarkdownBuilder mdbuilder = new MarkdownBuilder();
      Director director = new Director(mdbuilder);
      director.construct();
      String filename = mdbuilder.getResult();
      System.out.println(filename + " has been built.");
    } else {
      usage();
      System.exit(0);
    }
  }

  public static void usage() {
    System.out.println("Usage: java Main (plain|html|markdown)");
  }
}
