package famaly.people.token.worker.tokenworker.services.generate;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.request.SessionCookies;
import famaly.people.token.worker.tokenworker.auth.models.response.AuthorisationViewCredintailes;
import famaly.people.token.worker.tokenworker.auth.models.response.SessionValidationResponse;
import famaly.people.token.worker.tokenworker.exception.SessionIsNotValidException;

public interface SessionValidation {
    SessionValidationResponse validationSession(SessionCookies request) throws SessionIsNotValidException;
}
