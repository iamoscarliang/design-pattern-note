package mediator.device;

import mediator.Device;
import mediator.Event;

public class Sprinkler extends Device {

    @Override
    public void onEvent(Event event) {
        if (event == Event.WATERING_GARDEN) {
            System.out.println("Watering the garden!");
        }
    }

}
