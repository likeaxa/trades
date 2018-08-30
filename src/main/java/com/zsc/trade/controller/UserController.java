package com.zsc.trade.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsc.trade.bean.Admin;

import com.zsc.trade.bean.User;

import com.zsc.trade.service.AdminService;
import com.zsc.trade.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    /**
     * @param admin   客户端过来的adminName和password 采用@ModelAttribute自动装箱
     * @param session 登录成功后 那adminName放进session里面进行持久化会话操作
     * @return 成功登录返回 "ok",失败返回 "用户名或者密码错误"
     */
    //@RequestMapping(value = "/login",method = RequestMethod.GET)
    @PostMapping("/login")
    public String login(@RequestBody Admin admin, HttpSession session) {

        List<Admin> admins = adminService.getList();
        System.out.println(admin.getAdminName());
        for (Admin ad : admins) {

            if (ad.getAdminName().equals(admin.getAdminName())
                    && ad.getPassword().equals(admin.getPassword())) {
                //登录成功 放进session
                session.setAttribute("adminName", admin.getAdminName());
                return "ok";
            }
        }
        return "用户名或者密码错误";
    }

    /**
     * g =
     */
    //public int flag = 0;
    @GetMapping("/user")
    public PageInfo<User> getList(@RequestParam(value = "username", required = false) String username,
                                  @RequestParam(value = "start", defaultValue = "1") int start,
                                  @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {

        if (!username.equals("-1")) {
            System.out.println(username);
            //根据start,size进行分页，并且设置id 倒排序
            //PageHelper.startPage(start,100).setOrderBy("id desc");
            //因为PageHelper的作用，这里就好返回当前分页的集合
            List<User> us = userService.getSimpleUserByName(username);
            //创建PageInfo对象
            // PageInfo<User> page = new PageInfo<>(us);

            return new PageInfo<>(us);

        }
        System.out.println(username);
        //根据start,size进行分页，并且设置id 倒排序
        PageHelper.startPage(start, size).setOrderBy("id desc");
        //因为PageHelper的作用，这里就好返回当前分页的集合
        List<User> us = userService.getList();
        //创建PageInfo对象
        //  PageInfo<User> page = new PageInfo<>(us);
        return new PageInfo<>(us);

    }

    @PutMapping("/user")
    public String addUser(@ModelAttribute User user) {

        if (user != null) {
            return "插入失败";
        }
        userService.insert(user);

        return "ok";
    }

//    @PostMapping("/user")
//    public PageInfo<User> getSimpleUserByName(@RequestParam (value = "username") String username,
//                                          @RequestParam(value = "start",defaultValue = "0" )int start ,
//                                          @RequestParam(value = "size",defaultValue = "5") int size)throws Exception{
//
//
//        System.out.println(username);
//        //根据start,size进行分页，并且设置id 倒排序
//        PageHelper.startPage(start,size).setOrderBy("id desc");
//
//        //因为PageHelper的作用，这里就好返回当前分页的集合
//        List<User> us =userService.getSimpleUserByName(username);
//
//        //创建PageInfo对象
//        PageInfo<User> page = new PageInfo<>(us);
//
//        return  page;
//    }

    @DeleteMapping("/user")
    public String delete(@RequestParam(value = "user_id", defaultValue = "-1") int id) {

        if (id == -1) {
            return "删除失败";
        }
        userService.delete(id);
        return "ok";
    }
}
