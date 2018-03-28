package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.PropertyValueService;
import com.sun.tracing.dtrace.ArgsAttributes;
import oracle.jrockit.jfr.ProducerDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;

    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model,int pid){
        //找到对应的产品，并将对应的分类设置到产品对象上
        Product p=productService.get(pid);
        propertyValueService.init(p);
        //找到属性值，并将对应的属性(名字)设置到属性值上面
        List<PropertyValue> pvs=propertyValueService.list(p.getId());

        model.addAttribute("p",p);
        model.addAttribute("pvs",pvs);
        return "admin/editPropertyValue";
    }

    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue pv){
        //propertyValueService调用的是propertValueMapper.updateByPrimaryKeySelective(pv);
        // 这个方法只会更新propertyValue存在的字段，而参数PropertyValue只有id和value有值，
        // 所以即便这个PropertyValue对象没有pid和ptid值，修改的时候也不会影响该PropertyValue的pid和ptid。
        propertyValueService.update(pv);
        return "success";
    }

}
