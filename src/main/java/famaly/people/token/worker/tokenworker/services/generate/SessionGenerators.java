package famaly.people.token.worker.tokenworker.services.generate;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.response.AuthorisationViewCredintailes;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;

public interface SessionGenerators {
    AuthorisationViewCredintailes startSessionAuthorisation(AuthRequest request);
}
