package famaly.people.token.worker.tokenworker.auth.models.response;

import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.Token;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account.Account;

public class SessionModel {

    private String sessionName;
    private Account account;
    private Token token;


    public void initialize(String sessionName, String tokenStr, String clientName) {
        this.sessionName = sessionName;
    }


    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }
}

