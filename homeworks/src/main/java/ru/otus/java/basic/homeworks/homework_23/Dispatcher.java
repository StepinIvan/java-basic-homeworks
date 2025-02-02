package ru.otus.java.basic.homeworks.homework_23;

import ru.otus.java.basic.homeworks.homework_23.application.ProductsService;
import ru.otus.java.basic.homeworks.homework_23.processors.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Dispatcher {
    private Map<String, RequestProcessor> router;
    private Default404Processor default404Processor;
    private Default500Processor default500Processor;
    private Default400Processor default400Processor;

    public Dispatcher() {
        ProductsService productsService = new ProductsService();
        this.router = new HashMap<>();
        this.router.put("GET /calc", new CalculatorProcessor());
        this.router.put("GET /welcome", new WelcomeProcessor());
        this.router.put("GET /products", new GetProductsProcessor(productsService));
        this.router.put("POST /products", new CreateProductProcessor(productsService));
        this.router.put("DELETE /products", new DeleteProductProcessor(productsService));
        this.router.put("PUT /products", new PutProductProcessor(productsService));
        this.default404Processor = new Default404Processor();
        this.default500Processor = new Default500Processor();
        this.default400Processor = new Default400Processor();
    }

    public void execute(HttpRequest request, OutputStream output) throws IOException {
        try {
            router.getOrDefault(request.getRoutingKey(), default404Processor).execute(request, output);
        } catch (BadRequestException e) {
            e.printStackTrace();
            request.setErrorCause(e);
            default400Processor.execute(request, output);
        } catch (Exception e) {
            e.printStackTrace();
            default500Processor.execute(request, output);
        }
    }
}
