package famaly.people.token.worker.tokenworker.services.generate.authorisation;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public interface Authorization {
    SOAPMessage startAuthorisation(AuthRequest requesst) throws SOAPException;
}
