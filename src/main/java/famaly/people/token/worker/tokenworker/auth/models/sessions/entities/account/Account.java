package famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account;

import javax.validation.constraints.AssertTrue;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

public class Account extends User {
    private String accountId;
    private String login;
    private String rules;
    private boolean isValid;
    private XMLGregorianCalendar dateLogin;

    @Autowired
    private DateFormat dateFormat;
    @Autowired
    private GregorianCalendar gregorianCalendar;

    public void initialize(String name, String secondName, String accountId, String login,
                           String rules, boolean isValid, String dateLogin) {
        super.initialize(name, secondName);
        this.accountId = accountId;
        this.login = login;
        this.rules = rules;
        this.isValid = isValid;
        try{
            Date date = dateFormat.parse(dateLogin);
            gregorianCalendar.setTime(date);
            this.dateLogin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        }catch (DatatypeConfigurationException | ParseException ex){
            System.out.println(ex.getMessage());
        }
    }

    public XMLGregorianCalendar getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(XMLGregorianCalendar dateLogin) {
        this.dateLogin = dateLogin;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        accountId = accountId;
    }
}
