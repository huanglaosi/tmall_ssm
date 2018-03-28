package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {

    public void init(Product p);

    public void update(PropertyValue pv);

    public List<PropertyValue> list(int pid);

    public PropertyValue get(int ptid,int pid);

}
