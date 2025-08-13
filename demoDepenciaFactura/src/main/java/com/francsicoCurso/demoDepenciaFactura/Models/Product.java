package com.francsicoCurso.demoDepenciaFactura.Models;

public class Product {
    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public Product() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
