package famaly.people.token.worker.tokenworker.auth.models.request;

import javax.xml.datatype.XMLGregorianCalendar;

public class SessionCookies {
    private String sessionId;
    private String userName;
    private String tokenStr;
    private boolean validation;
    private XMLGregorianCalendar dateAuth;

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public XMLGregorianCalendar getDateAuth() {
        return dateAuth;
    }

    public void setDateAuth(XMLGregorianCalendar dateAuth) {
        this.dateAuth = dateAuth;
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
