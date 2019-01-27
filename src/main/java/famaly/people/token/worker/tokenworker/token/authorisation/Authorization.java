package famaly.people.token.worker.tokenworker.token.authorisation;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;

public interface Authorization {
    void startAuthorisation(AuthRequest requesst);
}
