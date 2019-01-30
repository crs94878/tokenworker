package famaly.people.token.worker.tokenworker.configuration;

import famaly.people.token.worker.tokenworker.auth.models.response.SessionModel;
import famaly.people.token.worker.tokenworker.token.service.SessionGenerators;
import famaly.people.token.worker.tokenworker.token.service.SessionReturning;
import famaly.people.token.worker.tokenworker.token.service.TokenService;
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
    public SessionModel getSessionModel(){
        return new SessionModel();
    }

    @Bean
    @Lazy
    public TokenService getTokenService(){
        return new TokenService();
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

}
