package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;

import java.util.List;

public interface ProductService {

    public void add(Product p);

    public void delete(int id);

    public Product get(int id);

    public void update(Product p);

    public List<Product> list(int cid);

    void setFirstProductImage(Product p);

    public void fill(Category category);

    public void fill(List<Category> categorys);

    public void fillByRow(List<Category> categorys);

    void setSaleAndReviewNumber(Product p);

    void setSaleAndReviewNumber(List<Product> ps);
}
