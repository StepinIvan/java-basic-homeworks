package ru.otus.java.basic.homeworks.homework_23.processors;

import ru.otus.java.basic.homeworks.homework_23.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;

public interface RequestProcessor {
    void execute(HttpRequest request, OutputStream outputStream) throws IOException;
}
