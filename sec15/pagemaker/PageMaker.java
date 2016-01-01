package pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

public class PageMaker {
  private PageMaker() {}

  public static void makeWelcomePage(String mailaddr, String filename) {
    try {
      Properties mailprop = Database.getProperties("maildata");
      String username = mailprop.getProperty(mailaddr);
      HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
      writer.title("Welcome to " + username + "'s page!");
      writer.paragraph("welcome to " + username + "'s page.");
      writer.paragraph("Feel free to send emails to me!");
      writer.mailto(mailaddr, username);
      writer.close();
      System.out.println(filename + " is created for " + mailaddr
                         + " (" + username + ")");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void makeLinkPage(String filename) {
    try {
      Properties mailprop = Database.getProperties("maildata");
      HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
      Iterator<String> keys = mailprop.stringPropertyNames().iterator();

      writer.title("Link Page");
      while (keys.hasNext()) {
        String mailaddr = keys.next();
        String username = mailprop.getProperty(mailaddr);
        writer.link(mailaddr, username);
      }
      writer.close();
      System.out.println(filename + " is created.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
