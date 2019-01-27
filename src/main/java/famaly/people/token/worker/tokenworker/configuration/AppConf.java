package famaly.people.token.worker.tokenworker.configuration;

import famaly.people.token.worker.tokenworker.auth.models.response.SessionModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import javax.xml.soap.*;

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
    public SessionModel getSessionModel(){
        return new SessionModel();
    }
}
