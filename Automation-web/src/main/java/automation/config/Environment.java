package automation.config;

public enum Environment {

    DEVELOPMENT(""),
    STAGING(""),
    PRODUCTION(""),
    PATH(System.getProperty("user.dir"));


    private final String url;

    Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}