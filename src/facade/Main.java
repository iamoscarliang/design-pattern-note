package facade;

import facade.device.Light;
import facade.device.Projector;
import facade.device.Screen;

public class Main {

    public static void main(String[] args) {
        Light light = new Light("Home theater");
        Screen screen = new Screen("Home theater");
        Projector projector = new Projector("Home theater");

        TheaterFacade theaterFacade = new TheaterFacade(light, screen, projector);
        theaterFacade.watchMovie("Lord of the ring");
        System.out.println("----- Playing movie -----");
        theaterFacade.endMovie();
    }

}
