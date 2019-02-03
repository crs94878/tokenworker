package famaly.people.token.worker.tokenworker.services.generate.authorisation.parser;

import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.Token;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account.Account;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.usersession.UserAuthSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.util.Map;

public class Parser implements Parsinng {

    @Autowired
    @Qualifier("parseMap")
    private Map responseEntityMap;

    @Autowired
    private Account account;

    @Autowired
    private Token token;

    @Override
    public void parse(SOAPMessage message) throws SOAPException{
        this.startParse(message);
    }

    private void startParse(SOAPMessage message){
        try {
            SOAPBody responseBody = message.getSOAPBody();
            NodeList nodeListResponse = responseBody.getElementsByTagName("ns2:token");
            NodeList childNode = nodeListResponse.item(0).getChildNodes();
            for(int index = 0; index < childNode.getLength(); index++) {
                String key = childNode.item(index).getLocalName();
                String value = childNode.item(index).getTextContent();
                responseEntityMap.put(key, value);
            }
        } catch (SOAPException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void inititalizeAccountAndToken(){
        String userNamme = (String)responseEntityMap.get("userName");
        String secondName = (String)responseEntityMap.get("useerSecondName");
        String login = (String)responseEntityMap.get("login");
        String rules = (String)responseEntityMap.get("rules");
        String valid = (String)responseEntityMap.get("validation");
        boolean validation = false;
        switch (valid) {
            case "true":
                validation = true;
                break;
            case "false":
                validation = false;
                break;
        }
        String tokenStr = (String)responseEntityMap.get("tokenStr");
        String accountId = (String)responseEntityMap.get("sessionId");
        String dateLogin = (String)responseEntityMap.get("dateLogin");
        account.initialize(userNamme, secondName, accountId,login, rules, validation, dateLogin);
        token.setTokenStr(tokenStr);
    }

    public Token getToken(){
        return this.token;
    }

    public Account getAccount(){
        return this.account;
    }
}
