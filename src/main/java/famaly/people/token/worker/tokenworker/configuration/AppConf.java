package famaly.people.token.worker.tokenworker.configuration;

import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.Token;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account.Account;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;
import famaly.people.token.worker.tokenworker.services.generate.SessionGenerators;
import famaly.people.token.worker.tokenworker.services.generate.SessionReturning;
import famaly.people.token.worker.tokenworker.services.generate.TokenService;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.Auth;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.Authorization;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.parser.Parser;
import famaly.people.token.worker.tokenworker.services.generate.authorisation.parser.Parsinng;
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
    public Map getSessionMap(){
        return new HashMap();
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
    @Scope(scopeName = "prototype")
    public Map<String, String> getMapResponseEntity(){
        return new HashMap<>();
    }

    @Bean
    @Lazy
    @Scope(scopeName = "prototype")
    public Token getToken(){
        return new Token();
    }

    @Bean
    @Lazy
    public SessionGenerators getSessionGenerators(TokenService tokenService){
        return tokenService;
    }

    @Bean
    @Lazy
    public SessionReturning sessionReturning(TokenService tokenService){
        return tokenService;
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
