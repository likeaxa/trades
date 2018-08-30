package com.zsc.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/cate")
    public String category() {
        return "category";
    }

    @RequestMapping("/cateEdit/*")
    public String cateEdit() {
        return "cateEdit";
    }

    @RequestMapping("/pro/*")
    public String product() {
        return "product";
    }


    @RequestMapping("/exch")
    public String exchange() {
        return "exchange";
    }

    @RequestMapping("/pict/")
    public String picture() {
        return "picture";
    }

    @RequestMapping("/use/*")
    public String user() {

        return "usermanager";
    }


}
