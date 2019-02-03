package famaly.people.token.worker.tokenworker.services.generate;

import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;

public interface SessionReturning {
    UserAuthSession getSessionModel();
}
