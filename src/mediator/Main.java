package mediator;

import mediator.device.Alarm;
import mediator.device.Calendar;
import mediator.device.CoffeeMachine;
import mediator.device.Sprinkler;

public class Main {

    public static void main(String[] args) {

        Device alarm = new Alarm();
        Device coffeeMachine = new CoffeeMachine();
        Device sprinkler = new Sprinkler();
        Device calendar = new Calendar("Monday");

        DeviceMediator mediator = new DeviceController(alarm, coffeeMachine, sprinkler, calendar);

        alarm.setMediator(mediator);
        coffeeMachine.setMediator(mediator);
        sprinkler.setMediator(mediator);
        calendar.setMediator(mediator);

        System.out.println("Alarm started!");
        alarm.onEvent(Event.STOP_ALARM);
    }

}
