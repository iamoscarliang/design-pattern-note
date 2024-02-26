package chainofresponsibility;

public class Main {

    public static void main(String[] args) {
        Handler spamHandler = new SpamHandler();
        Handler fansHandler = new FansHandler();
        Handler complaintHandler = new ComplaintHandler();

        spamHandler.setSuccessor(fansHandler);
        fansHandler.setSuccessor(complaintHandler);

        spamHandler.handlerRequest("This is a spam email");
        spamHandler.handlerRequest("This is a fans email");
        spamHandler.handlerRequest("This is a complaint email");
        spamHandler.handlerRequest("Unknown email");
    }

}
