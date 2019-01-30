package famaly.people.token.worker.tokenworker.auth.models.response.auth;

public class AuthTokenResponseEntity {
    private String tokenStr;
    private boolean isValid;

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }
}
