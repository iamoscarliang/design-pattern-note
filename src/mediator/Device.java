package mediator;

public abstract class Device {

    protected DeviceMediator mMediator;

    public void setMediator(DeviceMediator mediator) {
        mMediator = mediator;
    }

    public abstract void onEvent(Event event);

}
