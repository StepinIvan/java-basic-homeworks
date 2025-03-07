package ru.otus.java.basic.homeworks.homework_23.processors;

import com.google.gson.Gson;
import ru.otus.java.basic.homeworks.homework_23.BadRequestException;
import ru.otus.java.basic.homeworks.homework_23.HttpRequest;
import ru.otus.java.basic.homeworks.homework_23.application.ErrorDto;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Default400Processor implements RequestProcessor {
    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        ErrorDto errorDto = new ErrorDto(
                ((BadRequestException)request.getErrorCause()).getCode(),
                ((BadRequestException)request.getErrorCause()).getDescription()
        );
        Gson gson = new Gson();
        String jsonError = gson.toJson(errorDto);
        String response = "HTTP/1.1 400 Bad Request\r\n" +
                "Content-Type: application/json\r\n" +
                "\r\n" +
                jsonError;
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
