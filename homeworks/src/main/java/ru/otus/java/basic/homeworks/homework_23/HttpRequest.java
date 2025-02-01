package ru.otus.java.basic.homeworks.homework_23;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String rawRequest;
    private HttpMethod method;
    private String uri;
    private Map<String, String> parameters;
    private Map<String, String> headers;

    public String getRoutingKey() {
        return method + " " + uri;
    }

    public String getUri() {
        return uri;
    }

    public HttpRequest(String rawRequest) {
        this.rawRequest = rawRequest;
        parse();
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }
    private void parse() {
        this.parameters = new HashMap<>();
        this.headers = new HashMap<>();
        int startIndex = rawRequest.indexOf(' ');
        int endIndex = rawRequest.indexOf(' ', startIndex + 1);
        this.method = HttpMethod.valueOf(rawRequest.substring(0, startIndex));
        this.uri = rawRequest.substring(startIndex + 1, endIndex);
        if (this.uri.contains("?")) {
            String[] tokens = this.uri.split("[?]");
            this.uri = tokens[0];
            String[] paramsPairs = tokens[1].split("[&]");
            for (String o : paramsPairs) {
                String[] keyValue = o.split("=");
                this.parameters.put(keyValue[0],keyValue[1]);
            }
        }
        rawRequest.lines()
                .skip(1)
                .takeWhile(s -> !s.isBlank())
                .forEach(
                s -> {
                    String[] keyValue =s.split(": ");
                    headers.put(keyValue[0], keyValue[1]);
                }
        );
    }

    public void info(boolean showRawRequest) {
        System.out.println("METHOD: " + method);
        System.out.println("URI: " + uri);
        System.out.println("HEADERS: " + headers);
        if (showRawRequest) {
            System.out.println(rawRequest);
        }
    }
}
