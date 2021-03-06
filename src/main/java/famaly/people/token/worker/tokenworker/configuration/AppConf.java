package famaly.people.token.worker.tokenworker.configuration;

import famaly.people.token.worker.tokenworker.auth.models.response.AuthorisationViewCredintailes;
import famaly.people.token.worker.tokenworker.auth.models.response.SessionValidationResponse;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.Token;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account.Account;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;
import famaly.people.token.worker.tokenworker.services.generate.SessionGenerators;
import famaly.people.token.worker.tokenworker.services.generate.SessionValidation;
import famaly.people.token.worker.tokenworker.services.generate.TokenService;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.Auth;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.Authorization;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.parser.Parser;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.parser.Parsinng;
import famaly.people.token.worker.tokenworker.token.valid.SessionsMapWorker;
import famaly.people.token.worker.tokenworker.token.valid.UserSession;
import famaly.people.token.worker.tokenworker.token.valid.controls.SessionValidControls;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import javax.xml.soap.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConf {


    @Value("{soap.action}")
    private String action;

    @Bean
    public SOAPConnection getSOAPConnection(){
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            return soapConnectionFactory.createConnection();
        }catch (SOAPException ex){
            return null;
        }
    }

    @Bean
    public SOAPMessage getSOAPMessage(){
        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage message =messageFactory.createMessage();
            return messageFactory.createMessage();
        }catch (SOAPException ex){ System.out.println(ex.getMessage());
            return null;
        }
    }

    @Bean
    public SOAPEnvelope getSoapEnvelope(SOAPMessage message){
        try {
            SOAPPart soapPart = message.getSOAPPart();
            return soapPart.getEnvelope();
        } catch (SOAPException ex){
            return null;
        }
    }

    @Bean
    public MimeHeaders getMimeHeader(SOAPMessage message){
        MimeHeaders headers = message.getMimeHeaders();
        headers.addHeader("SOAPAction", action);
        return headers;
    }

    @Bean
    @Lazy
    @Scope(scopeName = "prototype")
    public AuthorisationViewCredintailes authorisationViewCredintailes(){
        return new AuthorisationViewCredintailes();
    }

    @Bean
    @Lazy
    public SessionsMapWorker sessionsMapWorker(){
        return new SessionsMapWorker();
    }

    @Bean(name = "sessionMap")
    @Lazy
    public Map<String, UserAuthSession> getSessionMap(){
        return new HashMap<>();
    }

    @Bean
    public DateFormat dateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    @Bean
    public GregorianCalendar gregorianCalendar(){
        return new GregorianCalendar();
    }

    @Bean
    @Lazy
    @Scope(scopeName = "prototype")
    public UserAuthSession getSessionModel(){
        return new UserAuthSession();
    }

    @Bean
    public Parsinng parsinng(){
        return new Parser();
    }

    @Bean
    @Lazy
    public TokenService getTokenService(){
        return new TokenService();
    }

    @Bean(name = "parseMap")
    @Lazy
    public Map<String, String> getMapResponseEntity(){
        return new HashMap<>();
    }

    @Bean
    @Lazy
    public SessionValidationResponse sessionValidationResponse(){
        return new SessionValidationResponse();
    }

    @Bean
    @Lazy
    @Scope(scopeName = "prototype")
    public Token getToken(){
        return new Token();
    }


    @Bean
    @Lazy
    @Scope(scopeName = "prototype")
    public Account account(){
        return new Account();
    }

    @Bean
    @Lazy
    public Authorization getAuthApi(){
        return new Auth();
    }

}
