package famaly.people.token.worker.tokenworker.services.generate;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.request.SessionCookies;
import famaly.people.token.worker.tokenworker.auth.models.response.AuthorisationViewCredintailes;
import famaly.people.token.worker.tokenworker.auth.models.response.SessionValidationResponse;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.Token;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account.Account;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;
import famaly.people.token.worker.tokenworker.exception.SessionIsNotValidException;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.Authorization;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.parser.Parsinng;
import famaly.people.token.worker.tokenworker.token.valid.UserSession;
import famaly.people.token.worker.tokenworker.token.valid.controls.SessionValidControls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class TokenService implements SessionGenerators, SessionValidation {

    @Autowired
    private Authorization authorization;

    @Autowired
    private Parsinng parser;

    @Autowired
    private UserAuthSession userAuthSession;

    @Autowired
    private SessionValidControls sessionValidControls;

    @Autowired
    private UserSession userSessionCollectionWorker;

    @Autowired
    private SessionValidationResponse response;

    @Autowired
    private AuthorisationViewCredintailes viewCredintailes;

    @Override
    public AuthorisationViewCredintailes startSessionAuthorisation(AuthRequest request) {
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
        userSessionCollectionWorker.saveUserSession(userAuthSession);
        sessionValidControls.startValidControlsSession();
        viewCredintailes.initialize(userAuthSession);
        return viewCredintailes;
    }
    @Override
    public SessionValidationResponse validationSession(SessionCookies request) throws SessionIsNotValidException {
        UserAuthSession session = userSessionCollectionWorker.getSavedSession(request);
        response.initialize(session.getSessionName(), session.isValidSession());
        return response;
    }
}
