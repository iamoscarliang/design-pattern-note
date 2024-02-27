package mediator.device;

import mediator.Device;
import mediator.Event;

public class CoffeeMachine extends Device {

    @Override
    public void onEvent(Event event) {
        if (event == Event.MAKE_COFFEE) {
            System.out.println("Make a cup of coffee!");
        }
    }

}
