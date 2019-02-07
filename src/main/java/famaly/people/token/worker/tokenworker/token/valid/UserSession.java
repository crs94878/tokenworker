package famaly.people.token.worker.tokenworker.token.valid;

import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;

public interface UserSession {
    void saveUserSession(UserAuthSession session);
    UserAuthSession getSavedSession(String sessionName);
    boolean isSessionFound(String login);

}
