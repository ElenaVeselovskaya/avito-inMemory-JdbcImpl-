package ru.itpark.connection;

public enum DBConnection {
    SQLITE("jdbc:sqlite:db.sqlite");

    private String value;
    DBConnection(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}

