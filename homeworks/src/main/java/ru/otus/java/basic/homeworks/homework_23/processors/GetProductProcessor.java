package ru.otus.java.basic.homeworks.homework_23.processors;

import ru.otus.java.basic.homeworks.homework_23.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GetProductProcessor implements RequestProcessor{
    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>GET Product</h1></body></html";
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
