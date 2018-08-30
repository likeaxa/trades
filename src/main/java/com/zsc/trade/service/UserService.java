package com.zsc.trade.service;

import com.zsc.trade.bean.User;

import java.util.List;

public interface UserService {
    List<User> getList();

    List<User> getSimpleUserByName(String name);

    User getUserById(Integer id);

    int insert(User user);

    void update(User user);

    void delete(Integer id);
}
