package chainofresponsibility;

public class ComplaintHandler extends Handler {

    @Override
    public void handlerRequest(String email) {
        if (email.contains("complaint")) {
            System.out.println("Send email to legal department!");
        } else {
            if (mSuccessor != null) {
                mSuccessor.handlerRequest(email);
            } else {
                System.out.println("Put email to pending email file!");
            }
        }
    }

}
