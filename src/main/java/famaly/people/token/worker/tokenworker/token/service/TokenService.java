package famaly.people.token.worker.tokenworker.token.service;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.response.SessionModel;
import org.springframework.beans.factory.annotation.Autowired;

public class TokenService implements SessionReturning, SessionGenerators {


    @Autowired
    private SessionModel session;

    @Override
    public SessionModel getSessionModel() {

        return null;
    }

    @Override
    public SessionModel startSessionAuthorisation(AuthRequest request) {
        return null;
    }
}
