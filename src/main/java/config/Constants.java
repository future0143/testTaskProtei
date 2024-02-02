package config;

public enum Constants {

    AUTH_PAGE("file:///Users/evgenia/Downloads/qa-test.html"),
    EMAIL("test@protei.ru"),
    PASSWORD("test");

    private final String data;

    Constants(String url) {
        this.data = url;
    }

    public String getData() {
        return data;
    }
}