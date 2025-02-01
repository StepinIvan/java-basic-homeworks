package ru.otus.java.basic.homeworks.homework_23;

import ru.otus.java.basic.homeworks.homework_23.processors.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Dispatcher {
    private Map<String, RequestProcessor> router;
    private Default404Processor default404Processor;

    public Dispatcher() {
        this.router = new HashMap<>();
        this.router.put("GET /calc", new CalculatorProcessor());
        this.router.put("GET /welcome", new WelcomeProcessor());
        this.router.put("GET /products", new GetProductProcessor());
        this.router.put("POST /products", new CreateProductProcessor());
        this.default404Processor = new Default404Processor();
    }

    public void execute(HttpRequest request, OutputStream output) throws IOException {
        router.getOrDefault(request.getRoutingKey(), default404Processor).execute(request, output);
    }
}
