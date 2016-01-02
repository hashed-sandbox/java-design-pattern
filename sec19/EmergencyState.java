public class EmergencyState implements State {
  private static EmergencyState singleton = new EmergencyState();

  private EmergencyState() {}

  public static EmergencyState getInstance() {
    return singleton;
  }

  public void doClock(Context context, int hour) {
    //
  }

  public void doUse(Context context) {
    context.callSecurityCenter("Using a Safe (emergency)");
  }

  public void doAlarm(Context context) {
    context.callSecurityCenter("An Emergency Call (emergency)");
  }

  public void doPhone(Context context) {
    context.callSecurityCenter("An Emergency Call (emergency)");
  }

  public String toString() {
    return "[emergency]";
  }
}
