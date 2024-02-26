package mediator;

public class Main {

    public static void main(String[] args) {

        Alarm alarm = new Alarm();
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Sprinkler sprinkler = new Sprinkler();
        Calendar calendar = new Calendar();

        DeviceMediator mediator = new DeviceController(alarm, coffeeMachine, sprinkler, calendar);

        alarm.setMediator(mediator);
        coffeeMachine.setMediator(mediator);
        sprinkler.setMediator(mediator);
        calendar.setMediator(mediator);

        calendar.setDate("Monday");
        System.out.println("-----Monday-----");
        System.out.println("Alarm started!");
        alarm.onEvent(Event.STOP_ALARM);

        calendar.setDate("Sunday");
        System.out.println("-----Sunday-----");
        System.out.println("Alarm started!");
        alarm.onEvent(Event.STOP_ALARM);
    }

}
