package com.how2java.tmall.service.impl;


        import com.how2java.tmall.mapper.ProductMapper;
        import com.how2java.tmall.pojo.Category;
        import com.how2java.tmall.pojo.Product;
        import com.how2java.tmall.pojo.ProductExample;
        import com.how2java.tmall.pojo.ProductImage;
        import com.how2java.tmall.service.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    OrderItemService orderItemService;

    /*
    list()和get()方法中把setCategory()和setProductImage()方法放进去了
     */

    public void add(Product p){
        productMapper.insert(p);
    }

    public void delete(int id){
        productMapper.deleteByPrimaryKey(id);
    }

    public void update(Product p){
        productMapper.updateByPrimaryKeySelective(p);
    }

   public Product get(int id){
        Product p=productMapper.selectByPrimaryKey(id);
       setFirstProductImage(p);
        setCategory(p);
        return p;
   }

   //后面业务会用到
    public void setCategory(List<Product> ps){
        for (Product p : ps)
            setCategory(p);
    }
    public void setCategory(Product p){
        int cid = p.getCid();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }

    public List<Product> list(int cid){
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        //返回Products
        List<Product> result=productMapper.selectByExample(example);
        setCategory(result);
        setFirstProductImage(result);
        return result;
    }


    @Override
    public void setFirstProductImage(Product p) {
        List<ProductImage> pis = productImageService.list(p.getId(), ProductImageService.type_single);
        if (!pis.isEmpty()) {
            ProductImage pi = pis.get(0);
            p.setFirstProductImage(pi);
        }
    }

    public void setFirstProductImage(List<Product> ps) {
        for (Product p : ps) {
            setFirstProductImage(p);
        }
    }

    public void fill(List<Category> categorys){
        for(Category category:categorys){
            fill(category);
        }
    }

    public void fill(Category category){
        List<Product> ps=list(category.getId());
        //p.getid()已经通过list(cid)方法返回
       //在list方法中就已经被设置了
        // setFirstProductImage(ps);
        category.setProducts(ps);
    }

    public void fillByRow(List<Category> categorys){
        int productsNumberEachRow = 8;
        for(Category c:categorys) {
            //ps属性已被全部返回

            List<Product> ps = list(c.getId());
            List<List<Product>> productsByRow = new ArrayList<>();
            for (int i = 0; i < ps.size(); i += productsNumberEachRow) {
                int size = i + productsNumberEachRow;
                size = size > ps.size() ? ps.size() : size;
                List<Product> productsOfEachRow = ps.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }

    @Override
    public void setSaleAndReviewNumber(Product p) {
        int saleCount = orderItemService.getSaleCount(p.getId());
        p.setSaleCount(saleCount);

        int reviewCount = reviewService.getCount(p.getId());
        p.setReviewCount(reviewCount);
    }

    @Override
    public void setSaleAndReviewNumber(List<Product> ps) {
        for (Product p : ps) {
            setSaleAndReviewNumber(p);
        }
    }


}
