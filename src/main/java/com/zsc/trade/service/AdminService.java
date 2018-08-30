package com.zsc.trade.service;

import com.zsc.trade.bean.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getList();


    int insert(Admin user);


    void delete(Integer id);
}
