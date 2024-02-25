package chainofresponsibility;

public abstract class Handler {

    protected Handler mSuccessor;

    public abstract void handlerRequest(String email);

    public Handler getSuccessor() {
        return mSuccessor;
    }

    public void setSuccessor(Handler handler) {
        mSuccessor = handler;
    }

}
