package com.zsc.trade.service.impl;

import com.zsc.trade.bean.Admin;
import com.zsc.trade.mapper.AdminMapper;
import com.zsc.trade.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> getList() {
        return adminMapper.getList();
    }

    @Override
    public int insert(Admin user) {
        return adminMapper.insert(user);
    }

    @Override
    public void delete(Integer id) {
        adminMapper.delete(id);
    }
}
