package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Property;

import java.util.List;

public interface PropertyService {

    public void add(Property c);

    public void delete(int id);

    public Property get(int id);

    public void update(Property c);

    public List list(int cid);
}
