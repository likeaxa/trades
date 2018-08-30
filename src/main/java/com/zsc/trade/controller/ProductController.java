package com.zsc.trade.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsc.trade.bean.Product;
import com.zsc.trade.bean.User;
import com.zsc.trade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public PageInfo<Product> getProduct(
            @RequestParam(value = "cate_id", defaultValue = "-1") int id
            , @RequestParam(value = "product_name", required = false) String pro_name
            , @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        //根据start,size进行分页，并且设置id 倒排序

        //   List<Product> pd = new ArrayList<Product>();

        if (!pro_name.equals("-1")) {
            System.out.println(pro_name + "****");
            PageHelper.startPage(start, 250).setOrderBy("id desc");
            // pd=productService.getSimpleProductByName(pro_name);
            return new PageInfo<Product>(productService.getSimpleProductByName(pro_name));
        }
        // System.out.println(pro_name);
        PageHelper.startPage(start, size).setOrderBy("id desc");

        // 创建PageInfo对象
        //PageInfo<Product> page = new PageInfo<Product>(pd);
        return new PageInfo<Product>(productService.getProduceById(id));
    }

    @PostMapping("/product")
    public String updateProduct(@ModelAttribute Product product) {
        if (product == null) {
            return "修改失败";
        }
        productService.update(product);
        return "ok";
    }

    @DeleteMapping("/product")
    public String delete(
            @RequestParam(value = "product_id"
                    , defaultValue = "-1") int id) {
        if (id == -1) {
            return "删除失败";
        }
        System.out.println(id + "********");
        productService.delete(id);
        return "ok";
    }

}
