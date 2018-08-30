package com.zsc.trade.service;

import com.zsc.trade.bean.Product;

import java.util.List;

public interface ProductService {

    List<Product> getSimpleProductByName(String name);

    List<Product> getAll();

    List<Product> getProduceById(Integer id);

    int Insert(Product produce);

    void update(Product produce);

    void delete(Integer id);
}
