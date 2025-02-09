package ru.otus.java.basic.homeworks.homework_23;

import lombok.Getter;

public class BadRequestException extends RuntimeException{
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private String code;
    private String description;

    public BadRequestException(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
