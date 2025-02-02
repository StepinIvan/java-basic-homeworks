package ru.otus.java.basic.homeworks.homework_23.processors;

import com.google.gson.Gson;
import ru.otus.java.basic.homeworks.homework_23.HttpRequest;
import ru.otus.java.basic.homeworks.homework_23.application.Product;
import ru.otus.java.basic.homeworks.homework_23.application.ProductsService;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class DeleteProductProcessor implements RequestProcessor{
    private ProductsService productsService;

    public DeleteProductProcessor(ProductsService productsService) {
        this.productsService = productsService;
    }
    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        Gson gson = new Gson();
        Product deletingProduct = gson.fromJson(request.getBody(),Product.class);
        productsService.deleteProduct(deletingProduct);
        String response = "HTTP/1.1 204 Delete successfully\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n";
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
