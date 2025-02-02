package ru.otus.java.basic.homeworks.homework_23.application;

public class Product {
    private Long id;
    private String title;

    public Product(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Product() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
