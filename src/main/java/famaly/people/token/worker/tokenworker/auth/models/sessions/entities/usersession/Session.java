package famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession;

import javax.xml.datatype.XMLGregorianCalendar;

public abstract class Session {
    protected XMLGregorianCalendar dateCreateSession;
    protected String sessionName;
    protected  boolean isValidSession;
    protected String appName;

    public String getSessionName(){
        return sessionName;
    }

    public  XMLGregorianCalendar getDateCreateSession(){
        return dateCreateSession;
    }

    public boolean isValidSession() {
        return isValidSession;
    }

    public void setValidSession(boolean value){
        this.isValidSession = value;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
