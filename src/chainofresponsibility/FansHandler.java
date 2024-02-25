package chainofresponsibility;

public class FansHandler extends Handler {

    @Override
    public void handlerRequest(String email) {
        if (email.contains("fans")) {
            System.out.println("Send email to manager!");
        } else {
            if (mSuccessor != null) {
                mSuccessor.handlerRequest(email);
            } else {
                System.out.println("Put email to pending email file!");
            }
        }
    }

}
