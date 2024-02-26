package mediator;

public class Sprinkler extends Device {

    @Override
    public void onEvent(Event event) {
        if (event == Event.WATERING_GARDEN) {
            System.out.println("Watering the garden!");
        }
    }

}
