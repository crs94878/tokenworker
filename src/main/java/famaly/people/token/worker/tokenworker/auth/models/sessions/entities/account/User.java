package famaly.people.token.worker.tokenworker.auth.models.sessions.entities.account;

public abstract class User {
    protected String name;
    protected String secondName;

    public void initialize(String name, String secondName){
        this.name = name;
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
