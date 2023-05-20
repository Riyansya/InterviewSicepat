package automation.config;

public class GlobalVariable {

    private String token;
    private static GlobalVariable globalVariable;

    public String publicToken = null;
    public String environment = Environment.DEVELOPMENT.getUrl();

    public String getUserToken() {
        return token;
    }

    public void setUserToken(String userToken) {
        this.token = userToken;
    }

    public static GlobalVariable getInstance() {
        if (globalVariable == null) {
            globalVariable = new GlobalVariable();
        }
        return globalVariable;
    }
}