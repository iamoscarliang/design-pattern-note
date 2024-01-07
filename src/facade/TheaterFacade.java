package facade;

import facade.device.Light;
import facade.device.Projector;
import facade.device.Screen;

public class TheaterFacade {

    private Light mLight;
    private Screen mScreen;
    private Projector mProjector;

    public TheaterFacade(Light light, Screen screen, Projector projector) {
        mLight = light;
        mScreen = screen;
        mProjector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch movie...");
        mLight.off();
        mScreen.down();
        mProjector.on();
        mProjector.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie down...");
        mLight.on();
        mScreen.up();
        mProjector.off();
    }

}
