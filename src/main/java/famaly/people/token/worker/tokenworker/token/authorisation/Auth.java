package famaly.people.token.worker.tokenworker.token.authorisation;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.soap.*;

public class Auth implements Authorization {

    @Autowired
    private SOAPMessage requestMessage;

    @Autowired
    private SOAPEnvelope envelope;

    @Autowired
    private SOAPConnection connection;

    @Autowired
    private MimeHeaders headers;

    @Value("{soap.endpoint.url}")
    private String endpointURL;

    @Value("{soap.namespace}")
    private String namespace;

    @Value("{soap.appname}")
    private String appName;

    @Value("{soap.namespace.url}")
    private String namespaceURL;

    @Value("{soap.action}")
    private String action;

    @Override
    public void startAuthorisation(AuthRequest requesst) {
        this.createSOAPRequestMessage(requesst);
        this.connectToAuthService();
    }

    private void createSOAPRequestMessage(AuthRequest request){
        try {
            requestMessage.getSOAPBody().removeContents();
            envelope.addNamespaceDeclaration(namespace, namespaceURL);
            headers.addHeader("SOAPAction", action);
            SOAPBody soapBody = envelope.getBody();
            SOAPElement authRequestElement = soapBody.addChildElement("authRequest", namespace);
            SOAPElement loginElement = authRequestElement.addChildElement("login", namespace);
            SOAPElement passElement = authRequestElement.addChildElement("password", namespace);
            SOAPElement appNameElemeent = authRequestElement.addChildElement("applicationnName", namespace);
            loginElement.addTextNode(request.getLogin());
            passElement.addTextNode(request.getPassword());
            appNameElemeent.addTextNode(appName);
            requestMessage.saveChanges();
        } catch (SOAPException ex){
            System.out.println(ex.getMessage());
        }
    }

    private SOAPMessage connectToAuthService(){
        try {
            return connection.call(requestMessage, endpointURL);
            }catch (SOAPException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
