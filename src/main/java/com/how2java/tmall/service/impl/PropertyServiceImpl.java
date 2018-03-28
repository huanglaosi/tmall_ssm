package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.PropertyMapper;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyExample;
import com.how2java.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyMapper propertyMapper;

    public void add(Property p){
        propertyMapper.insert(p);
    }

    public void delete(int id){
        propertyMapper.deleteByPrimaryKey(id);
    }

    public void update(Property p){
        //修改还提供了一个updateByPrimaryKeySelective，其作用是只修改变化了的字段，未变化的字段就不修改了。
        propertyMapper.updateByPrimaryKeySelective(p);
    }

    public Property get(int id){
        return propertyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List list(int cid){
        PropertyExample example=new PropertyExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        return propertyMapper.selectByExample(example);
    }
}
