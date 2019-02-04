package famaly.people.token.worker.tokenworker.services.generate;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.Token;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account.Account;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.Authorization;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.parser.Parsinng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class TokenService implements SessionReturning, SessionGenerators {

    @Autowired
    private Authorization authorization;

    @Autowired
    private Parsinng parser;

    @Autowired
    private UserAuthSession userAuthSession;

    @Override
    public UserAuthSession startSessionAuthorisation(AuthRequest request) {
        try {
            SOAPMessage responseMessage = authorization.startAuthorisation(request);
            parser.parse(responseMessage);
            Account account = parser.getAccount();
            Token token = parser.getToken();
            userAuthSession.initUserAuthSession(account.getAccountId(), account.getDateLogin(), true,
                    account, token, request.getAppName());
        }catch (SOAPException ex){
            System.out.println(ex.getMessage());
        }
        return userAuthSession;
    }

    @Override
    public UserAuthSession getSessionModel() {
        return null;
    }
}
