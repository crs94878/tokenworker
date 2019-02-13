package famaly.people.token.worker.tokenworker.token.valid;

import com.sun.istack.NotNull;
import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.request.SessionCookies;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;
import famaly.people.token.worker.tokenworker.exception.SessionIsNotValidException;
import famaly.people.token.worker.tokenworker.token.valid.controls.SessionValidControls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SessionsMapWorker implements UserSession, SessionValidControls {


    private boolean isTaskStart = false;

    @Autowired
    @Qualifier("sessionMap")
    private Map<String, UserAuthSession> sessionsMap;

    @Override
    public void saveUserSession(UserAuthSession session) throws NullPointerException{
        if(session == null) throw new NullPointerException("Sesssion isn't be null");
        sessionsMap.putIfAbsent(session.getSessionName(), session);
    }

    @Override
    public UserAuthSession getSavedSession(@NotNull SessionCookies request) throws SessionIsNotValidException{
        UserAuthSession session = sessionsMap.get(request.getSessionId());
        if(!session.getSessionName().equals(request.getSessionId()) || !session.getUser().getName().equals(request.getUserName()) ||
                !session.getTokenUser().getTokenStr().equals(request.getTokenStr()) || !session.isValidSession()){
            throw new SessionIsNotValidException("Сессия не валидна");
        }
        return session;
    }

    @Override
    public boolean isSessionFound(@NotNull String login) {
        return sessionsMap.containsKey(login);
    }


    @Override
    public void startValidControlsSession() {
        if(!isTaskStart){
            HashMap<String, UserAuthSession> oldSessions = new HashMap<>();
            Runnable taskValidSesion = () ->{
                isTaskStart = true;
                while(true){
                    Iterator<Map.Entry<String, UserAuthSession>> iterator =
                            sessionsMap.entrySet().iterator();
                        while (iterator.hasNext()){
                            UserAuthSession session = iterator.next().getValue();
                            if (isNeadChanggeState(session)) {
                                session.setValidSession(false);
                            }
                        }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex){}
                }
            };
            new Thread(taskValidSesion, "Valid Session Thread").start();
        }
    }

    private boolean isNeadChanggeState(@NotNull UserAuthSession session){
//        int dayLogin = session.getDateCreateSession().toGregorianCalendar().get(GregorianCalendar.DAY_OF_YEAR);
        int hourLogin = session.getDateCreateSession().getHour();
        int minutLogin = session.getDateCreateSession().getMinute();
        int secondLogin = session.getDateCreateSession().getSecond();
        LocalDateTime localDateTime = LocalDateTime.now();
        //session.getDateCreateSession().toGregorianCalendar().toZonedDateTime().toLocalDateTime().is
        boolean l =((localDateTime.getHour() - hourLogin) == 0) & ((localDateTime.getMinute() - minutLogin) > 0);
        if(((localDateTime.getHour() - hourLogin) == 0) & ((localDateTime.getMinute() - minutLogin) > 0) ||
                ((localDateTime.getHour() - hourLogin) > 0 & ((minutLogin - localDateTime.getMinute()) >10))){
            return true;
        }
        return false;
    }
}
