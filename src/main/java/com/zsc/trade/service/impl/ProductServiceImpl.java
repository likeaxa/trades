package com.zsc.trade.service.impl;

import com.zsc.trade.bean.Product;
import com.zsc.trade.mapper.ProductMapper;
import com.zsc.trade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getSimpleProductByName(String name) {
        return productMapper.getSimpleProductByName(name);
    }

    @Override
    public List<Product> getAll() {
        return productMapper.getAll();
    }

    @Override
    public List<Product> getProduceById(Integer id) {
        return productMapper.getProduceById(id);
    }

    @Override
    public int Insert(Product produce) {
        return productMapper.Insert(produce);
    }

    @Override
    public void update(Product produce) {
        productMapper.update(produce);
    }

    @Override
    public void delete(Integer id) {
        productMapper.delete(id);
    }
}
