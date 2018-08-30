package com.zsc.trade.service;

import com.zsc.trade.bean.Category;

import java.util.List;

public interface CategoryService {


    List<Category> getAll();

    Category getCategoryById(Integer id);

    int insert(Category category);

    void update(Category category);

    void delete(Integer id);
}
