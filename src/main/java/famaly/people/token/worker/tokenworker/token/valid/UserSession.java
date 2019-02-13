package famaly.people.token.worker.tokenworker.token.valid;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.request.SessionCookies;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;
import famaly.people.token.worker.tokenworker.exception.SessionIsNotValidException;

public interface UserSession {
    void saveUserSession(UserAuthSession session);
    UserAuthSession getSavedSession(SessionCookies request) throws SessionIsNotValidException;
    boolean isSessionFound(String login);

}
