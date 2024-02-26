package mediator;

public class DeviceController implements DeviceMediator {

    private Alarm mAlarm;
    private CoffeeMachine mCoffeeMachine;
    private Sprinkler mSprinkler;
    private Calendar mCalendar;

    public DeviceController(Alarm alarm, CoffeeMachine coffeeMachine, Sprinkler sprinkler, Calendar calendar) {
        mAlarm = alarm;
        mCoffeeMachine = coffeeMachine;
        mSprinkler = sprinkler;
        mCalendar = calendar;
    }

    @Override
    public void sendEvent(Event event) {
        switch (event) {
            case TURN_ON_SYSTEM:
                mCalendar.onEvent(Event.CHECK_CALENDER);
                break;
            case WORKDAY:
                mCoffeeMachine.onEvent(Event.MAKE_COFFEE);
                break;
            case WEEKEND:
                mSprinkler.onEvent(Event.WATERING_GARDEN);
                break;
        }
    }

}
