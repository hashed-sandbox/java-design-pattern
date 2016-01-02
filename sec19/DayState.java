public class DayState implements State {
  private static DayState singleton = new DayState();

  private DayState() {}

  public static State getInstance() {
    return singleton;
  }

  public void doClock(Context context, int hour) {
    if (12 <= hour && hour < 13) {
      context.changeState(LunchState.getInstance());
    } else if (hour < 9 || 17 <= hour) {
      context.changeState(NightState.getInstance());
    }
  }

  public void doUse(Context context) {
    context.recordLog("Using a Safe (daytime)");
  }

  public void doAlarm(Context context) {
    context.callSecurityCenter("An Emergency Call (daytime)");
    context.changeState(EmergencyState.getInstance());
  }

  public void doPhone(Context context) {
    context.callSecurityCenter("An ordinary phone (daytime)");
  }

  public String toString() {
    return "[daytime]";
  }
}
