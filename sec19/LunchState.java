public class LunchState implements State {
  private static LunchState singleton = new LunchState();

  private LunchState() {}

  public static LunchState getInstance() {
    return singleton;
  }

  public void doClock(Context context, int hour) {
    if (hour < 12 || 13 <= hour) {
      context.changeState(DayState.getInstance());
    }
  }

  public void doUse(Context context) {
    context.callSecurityCenter("Emergency: Using a Safe while Lunch!");
  }

  public void doAlarm(Context context) {
    context.callSecurityCenter("An Emergency Alarm (lunch)");
    context.changeState(EmergencyState.getInstance());
  }

  public void doPhone(Context context) {
    context.recordLog("A Phone Recording while Lunch");
  }

  public String toString() {
    return "[lunch]";
  }
}
