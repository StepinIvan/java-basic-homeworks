package ru.otus.java.basic.homeworks.homework_23.processors;

import com.google.gson.Gson;
import ru.otus.java.basic.homeworks.homework_23.HttpRequest;
import ru.otus.java.basic.homeworks.homework_23.application.Product;
import ru.otus.java.basic.homeworks.homework_23.application.ProductsService;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PutProductProcessor implements RequestProcessor{
    private ProductsService productsService;

    public PutProductProcessor(ProductsService productsService) {
        this.productsService = productsService;
    }
    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        String response;
        Gson gson = new Gson();
        if (request.containsParameter("id") && Integer.parseInt(request.getParameter("id")) <=
                productsService.getAllProducts().size()) {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getBody().split("\"title\": ")[1].split("\"")[1];
            productsService.updateProduct(id - 1, title);
            response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n";
        } else {
            Product newProduct = gson.fromJson(request.getBody(),Product.class);
            productsService.createNewProduct(newProduct);
            response = "HTTP/1.1 201 Created\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n";
        }
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
