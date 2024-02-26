package mediator;

public class Alarm extends Device {

    @Override
    public void onEvent(Event event) {
        if (event == Event.STOP_ALARM) {
            System.out.println("Alarm stopped!");
            mMediator.sendEvent(Event.TURN_ON_SYSTEM);
        }
    }

}
