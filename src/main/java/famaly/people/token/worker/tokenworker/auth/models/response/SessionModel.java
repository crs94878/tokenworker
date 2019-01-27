package famaly.people.token.worker.tokenworker.auth.models.response;

public class SessionModel {

    private String sessionName;
    private String tokenStr;
    private String clientName;

    public String getTokenStr() {
        return tokenStr;
    }

    public void initialize(String sessionName, String tokenStr, String clientName){
        this.sessionName = sessionName;
        this.tokenStr = tokenStr;
        this.clientName = clientName;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
