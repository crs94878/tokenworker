package famaly.people.token.worker.tokenworker.auth.models.response;

public class SessionValidationResponse {
    private String sessionName;
    private boolean isValid;

    public void initialize(String nameSession, boolean valid){
        sessionName = nameSession;
        isValid = valid;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }
}
