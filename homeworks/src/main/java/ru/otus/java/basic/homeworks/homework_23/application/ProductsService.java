package ru.otus.java.basic.homeworks.homework_23.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductsService {
    private List<Product> products;

    public ProductsService() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk"),
                new Product(2L, "Bread"),
                new Product(3L, "Cheese")
        )
        );
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }
    public Product getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public void createNewProduct(Product product) {
        Long newId = products.stream().mapToLong(Product::getId).max().getAsLong() + 1;
        products.add(new Product(newId, product.getTitle()));
    }
    public void deleteProduct(String title) {
        products.removeIf(product -> product.getTitle().equals(title));
    }
    public void deleteProduct() {
        products.clear();
    }
    public void updateProduct(int id, String title) {
        Product product = products.get(id);
        product.setTitle(title);
    }
}
