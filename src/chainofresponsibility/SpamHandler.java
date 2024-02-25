package chainofresponsibility;

public class SpamHandler extends Handler {

    @Override
    public void handlerRequest(String email) {
        if (email.contains("spam")) {
            System.out.println("Delete spam email!");
        } else {
            if (mSuccessor != null) {
                mSuccessor.handlerRequest(email);
            } else {
                System.out.println("Put email to pending email file!");
            }
        }
    }

}
