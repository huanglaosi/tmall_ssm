package com.how2java.tmall.pojo;

import java.util.List;

public class Category {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    private List<Product> Products;

    private List<List<Product>> ProductsByRow;

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public List<List<Product>> getProductsByRow() {
        return ProductsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        ProductsByRow = productsByRow;
    }
}