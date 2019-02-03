package famaly.people.token.worker.tokenworker.services.generate.authorisation.parser;

import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.Token;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account.Account;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public interface Parsinng {
    void parse(SOAPMessage message) throws SOAPException;
    Account getAccount();
    Token getToken();
}
