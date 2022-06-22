package app.model.users;

public class User {
    private String userId;
    private String userFirstName;
    private String userLastName;
    private String userLogin;
    private String userPassword;
    private int clientBankAccs;
    private int clientCards;
    private int clientCredit;
    private ROLE role;

    public User(){

    }

    public User(String userId, String userLogin, String userPassword, String userFirstName, String userLastName, int clientBankAccs, int clientCards, int clientCredit, ROLE role) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.clientBankAccs = clientBankAccs;
        this.clientCards = clientCards;
        this.clientCredit = clientCredit;
        this.role = role;
    }

    public User(String userId, String userLogin, String userPassword, ROLE role) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.role = role;
    }

    public User(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String  userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getclientBankAccs() {
        return clientBankAccs;
    }

    public void setclientBankAccs(int clientBankAccs) {
        this.clientBankAccs = clientBankAccs;
    }

    public int getclientCards() {
        return clientCards;
    }

    public void setclientCards(int clientCards) {
        this.clientCards = clientCards;
    }

    public int getclientCredit() {
        return clientCredit;
    }

    public void setclientCredit(int clientCredit) {
        this.clientCredit = clientCredit;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public enum ROLE {
        USER, ADMIN, UNKNOWN
    }
}
