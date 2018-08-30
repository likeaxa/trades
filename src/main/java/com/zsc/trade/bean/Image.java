package com.zsc.trade.bean;

import java.util.List;

public class Image {
    private Integer id;
    private Integer product_id;
    // private Integer type;


    //非数据库字段
    private String link;


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

}
