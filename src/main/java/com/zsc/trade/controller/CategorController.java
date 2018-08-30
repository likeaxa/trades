package com.zsc.trade.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsc.trade.bean.Category;

import com.zsc.trade.bean.Product;
import com.zsc.trade.service.CategoryService;
import com.zsc.trade.service.ProductService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CategorController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    /**
     * @param start 在参数里接受当前是第几页 start ，默认值是0
     * @param size  以及每页显示多少条数据 size, 默认值是5。
     * @return 返回当前页的分类
     * @throws Exception
     */
    @GetMapping("/category")
    public PageInfo<Category> listCategory(@RequestParam(value = "start", defaultValue = "1") int start,
                                           @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        System.out.println(start);
        //根据start,size进行分页，并且设置id 倒排序
        PageHelper.startPage(start, size).setOrderBy("id desc");

        //因为PageHelper的作用，这里就好返回当前分页的集合
        List<Category> cs = categoryService.getAll();

        //创建PageInfo对象
        // PageInfo<Category> page = new PageInfo<>(cs);
        return new PageInfo<>(cs);

    }

    @GetMapping("/one_category")
    public Category getOneCategory(@RequestParam("cate_id") int id) {
        System.out.println(id);
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/category")
    public String addCategory(@RequestBody Category category) {


        if (category != null) {

            categoryService.insert(category);

            return "ok";
        }
        return "添加失败";
    }

    @PostMapping("/category")
    public String updateCategory(@RequestBody Category category) {

        if (category != null) {
            System.out.println(category.getId() + "++++++");
            System.out.println(category.getCate_name());
            categoryService.update(category);
            return "ok";
        }

        return "修改失败";
    }

    @DeleteMapping("/category")
    public String deleteCategory(@RequestParam(value = "cate_id", defaultValue = "-1") int cate_id) {
        if (cate_id == -1) {
            return "删除失败";
        }
        categoryService.delete(cate_id);

        return "ok";
    }
}
