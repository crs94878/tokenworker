package famaly.people.token.worker.tokenworker.auth.models.response;

import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;

import java.time.LocalDateTime;

public class AuthorisationViewCredintailes {

    private String sessionId;
    private String userName;
    private String tokenStr;
    private boolean validation;
    private LocalDateTime dateAuth;

    public void initialize(UserAuthSession session){
        this.sessionId = session.getSessionName();
        this.userName = session.getUser().getName();
        this.tokenStr = session.getTokenUser().getTokenStr();
        this.validation = session.isValidSession();
        this.dateAuth = session.getDateCreateSession().toGregorianCalendar().toZonedDateTime().toLocalDateTime();
    }

    public LocalDateTime getDateAuth() {
        return dateAuth;
    }

    public void setDateAuth(LocalDateTime dateAuth) {
        this.dateAuth = dateAuth;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
