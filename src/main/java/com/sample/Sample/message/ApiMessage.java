package com.sample.Sample.message;

public enum ApiMessage {

    ENTER_GET_ALL_USER("enter get all user."),

    ENTER_GET_USER("enter get user."),

    EXIT_GET_ALL_USER("exit get all user."),

    EXIT_GET_USER("exit get user."),

    GET_USER("get user. userId = %s"),

    INVALID_USER_ID("invalid user id."),

    USERS_ARE_NOT_EXISTS("users are not exists."),

    USER_IS_NOT_EXISTS("user is not exists. userId = %s");

    private String name;

    private ApiMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
