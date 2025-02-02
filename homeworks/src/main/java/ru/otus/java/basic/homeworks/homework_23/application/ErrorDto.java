package ru.otus.java.basic.homeworks.homework_23.application;

import java.time.LocalDateTime;

public class ErrorDto {
    private String code;
    private String description;
    private String timestamp;

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = LocalDateTime.now().toString();
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public ErrorDto(String code, String description) {
        this.code = code;
        this.description = description;
        this.timestamp = LocalDateTime.now().toString();
    }
}
