package automation.config;

public enum Environment {

    DEVELOPMENT("https://jsonplaceholder.typicode.com/"),
    STAGING(""),
    PRODUCTION("");

    private final String url;

    Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}