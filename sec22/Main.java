import command.*;
import drawer.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
  private MacroCommand history = new MacroCommand();
  private DrawCanvas canvas = new DrawCanvas(400, 400, history);
  private JButton redButton   = new JButton("red");
  private JButton blueButton  = new JButton("blue");
  private JButton undoButton  = new JButton("undo");
  private JButton clearButton = new JButton("clear");

  public Main(String title) {
    super(title);

    redButton.addActionListener(this);
    blueButton.addActionListener(this);
    undoButton.addActionListener(this);
    clearButton.addActionListener(this);
    canvas.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
      }
    });
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    Box buttonBox = new Box(BoxLayout.X_AXIS);
    buttonBox.add(redButton);
    buttonBox.add(blueButton);
    buttonBox.add(undoButton);
    buttonBox.add(clearButton);
    Box mainBox = new Box(BoxLayout.Y_AXIS);
    mainBox.add(buttonBox);
    mainBox.add(canvas);
    getContentPane().add(mainBox);

    pack();
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == redButton) {
      Command cmd = new ColorCommand(canvas, Color.red);
      history.append(cmd);
      cmd.execute();
    } else if (e.getSource() == blueButton) {
      Command cmd = new ColorCommand(canvas, Color.blue);
      history.append(cmd);
      cmd.execute();
    } else if (e.getSource() == undoButton) {
      history.undo();
      canvas.repaint();
    } else if (e.getSource() == clearButton) {
      history.clear();
      canvas.repaint();
    }
  }

  public static void main(String[] args) {
    new Main("Command Pattern Sample");
  }
}
