import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {
  private TextField textClock = new TextField(60);
  private TextArea textScreen = new TextArea(10, 60);
  private Button buttonUse   = new Button("Safe");
  private Button buttonAlarm = new Button("Alarm");
  private Button buttonPhone = new Button("Phone");
  private Button buttonExit  = new Button("Exit");

  private State state = DayState.getInstance();

  public SafeFrame(String title) {
    super(title);
    setBackground(Color.lightGray);
    setLayout(new BorderLayout());

    add(textClock, BorderLayout.NORTH);
    textClock.setEditable(false);

    add(textScreen, BorderLayout.CENTER);
    textScreen.setEditable(false);

    Panel panel = new Panel();
    panel.add(buttonUse);
    panel.add(buttonAlarm);
    panel.add(buttonPhone);
    panel.add(buttonExit);

    add(panel, BorderLayout.SOUTH);

    pack();
    setVisible(true);

    buttonUse.addActionListener(this);
    buttonAlarm.addActionListener(this);
    buttonPhone.addActionListener(this);
    buttonExit.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println(e);
    if (e.getSource() == buttonUse) {
      state.doUse(this);
    } else if (e.getSource() == buttonAlarm) {
      state.doAlarm(this);
    } else if (e.getSource() == buttonPhone) {
      state.doPhone(this);
    } else if (e.getSource() == buttonExit) {
      System.exit(0);
    } else {
      System.out.println("?");
    }
  }

  public void setClock(int hour) {
    String clockstring = "It's ";
    if (hour < 10) {
      clockstring += "0" + hour + ":00";
    } else {
      clockstring += hour + ":00";
    }
    System.out.println(clockstring);
    textClock.setText(clockstring);
    state.doClock(this, hour);
  }

  public void changeState(State state) {
    System.out.println("Changed from " + this.state + " to " + state);
    this.state = state;
  }

  public void callSecurityCenter(String msg) {
    textScreen.append("call! " + msg + "\n");
  }

  public void recordLog(String msg) {
    textScreen.append("record ... " + msg + "\n");
  }
}
