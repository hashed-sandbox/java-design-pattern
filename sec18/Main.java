import game.Gamer;
import game.Memento;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
  private static final String SAVEFILENAME = "game.dat";

  public static void main(String[] args) {
    Gamer gamer = new Gamer(100);
    Memento memento = loadUserData(gamer);
    for (int i = 0; i < 100; i++) {
      System.out.println("==== " + i);
      System.out.println("Status:" + gamer);

      gamer.bet();

      System.out.println("You have " + gamer.getMoney() + " yen.");

      if (gamer.getMoney() > memento.getMoney()) {
        System.out.println("    (Saving)");
        memento = gamer.createMemento();
        saveUserData(memento);
      } else if (gamer.getMoney() < memento.getMoney() / 2) {
        System.out.println("    (Restoring)");
        gamer.restoreMemento(memento);
      }

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
      }
      System.out.println("");
    }
  }

  private static Memento loadUserData(Gamer gamer) {
    Memento memento;
    try {
      FileInputStream fis = new FileInputStream(SAVEFILENAME);
      ObjectInputStream ois = new ObjectInputStream(fis);
      memento = (Memento) ois.readObject();
      gamer.restoreMemento(memento);
      ois.close();
    } catch (FileNotFoundException e) {
      System.out.println("couldn't find game.dat");
      memento = gamer.createMemento();
    } catch (Exception e) {
      e.printStackTrace();
      memento = gamer.createMemento();
    }
    return memento;
  }

  private static void saveUserData(Memento memento) {
    try {
      FileOutputStream fos = new FileOutputStream(SAVEFILENAME);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(memento);
      oos.close();
    } catch (Exception e) {
      System.out.println("couldn't save your data.");
      e.printStackTrace();
    }
  }
}
