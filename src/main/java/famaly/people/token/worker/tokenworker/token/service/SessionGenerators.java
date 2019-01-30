package famaly.people.token.worker.tokenworker.token.service;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.response.SessionModel;

public interface SessionGenerators {
    SessionModel startSessionAuthorisation(AuthRequest request);
}
