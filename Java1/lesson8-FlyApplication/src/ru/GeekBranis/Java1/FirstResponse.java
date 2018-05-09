package ru.GeekBranis.Java1;

public class FirstResponse {
    private boolean success;
    private int code;
    private String message;
    private String search_id;
    private String type;
    private int client;


    public boolean isSuccess() {
        return success;
    }

    public String getSearch_id() {
        return search_id;
    }

    @Override
    public String toString() {
        return "{success:" + success + ",code:" + code + ",message:" + message + ",search_id:" + search_id + ",type:" + type + ",client:" + client + "}";
    }

}
