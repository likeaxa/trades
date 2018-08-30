package com.zsc.trade.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsc.trade.bean.Category;
import com.zsc.trade.bean.ExchSerach;
import com.zsc.trade.bean.Exchange;
import com.zsc.trade.service.ExchangeService;
import com.zsc.trade.service.ProductService;
import com.zsc.trade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ExchangeController {
    @Autowired
    ExchangeService exchangeService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/exchange")
    public PageInfo<Exchange> getAll(@RequestParam(value = "start", defaultValue = "1") int start
            , @RequestParam(value = "size", defaultValue = "5") int size) {
        //这里有可能有包装进用户和商品的信息
        //根据start,size进行分页，并且设置id 倒排序
        PageHelper.startPage(start, size).setOrderBy("id desc");

        //因为PageHelper的作用，这里就好返回当前分页的集合

        List<Exchange> ex = exchangeService.getAll();

        return new PageInfo<>(ex);
    }

    @PutMapping("/exchange")
    public PageInfo<Exchange> search(@RequestBody ExchSerach exchSerach) {

        PageHelper.startPage(exchSerach.getStart(), 5).setOrderBy("id desc");
        List<Exchange> ex = exchangeService.getSearch(exchSerach);
        return new PageInfo<>(ex);
    }

    @PostMapping("/exchange")
    public String update(@ModelAttribute Exchange exchange) {

        if (exchange == null) {
            return "修改失败";
        }
        exchangeService.update(exchange);
        return "ok";
    }

    @DeleteMapping("/exchange")
    public String delete(@RequestParam(value = "delete_id", defaultValue = "-1") int id) {

        if (id == -1) return "删除失败";
        exchangeService.delete(id);

        return "ok";
    }
}
