package famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession;

import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.Token;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account.Account;

import javax.xml.datatype.XMLGregorianCalendar;

public class UserAuthSession extends Session {
    private Account user;
    private Token tokenUser;

    public  void initUserAuthSession(String sessionName, XMLGregorianCalendar dateCreateSession,
                                     boolean isValidSession, Account user, Token token, String appName){
        super.sessionName = sessionName;
        super.dateCreateSession = dateCreateSession;
        super.isValidSession = isValidSession;
        this.user = user;
        this.tokenUser = token;
        super.appName = appName;
    }

    public Token getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(Token tokenUser) {
        this.tokenUser = tokenUser;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }
}
