package mediator;

import mediator.device.Alarm;
import mediator.device.Calendar;
import mediator.device.CoffeeMachine;
import mediator.device.Sprinkler;

public class DeviceController implements DeviceMediator {

    private Device mAlarm;
    private Device mCoffeeMachine;
    private Device mSprinkler;
    private Device mCalendar;

    public DeviceController(Device alarm, Device coffeeMachine, Device sprinkler, Device calendar) {
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
