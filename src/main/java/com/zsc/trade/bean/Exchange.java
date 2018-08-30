package com.zsc.trade.bean;

import java.util.Date;

public class Exchange {
    private Integer id;
    private Integer seller_user_id;
    private Integer buyer_user_id;
    private Integer product_id;
    private Date trade_time;
    private Integer trade_number;
    private double total;
    private String status;
    //非数据库字段
    private User seller_user;

    private User buyer_user;

    private Product product;


    public User getSeller_user() {
        return seller_user;
    }

    public void setSeller_user(User seller_user) {
        this.seller_user = seller_user;
    }

    public User getBuyer_user() {
        return buyer_user;
    }

    public void setBuyer_user(User buyer_user) {
        this.buyer_user = buyer_user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeller_user_id() {
        return seller_user_id;
    }

    public void setSeller_user_id(Integer seller_user_id) {
        this.seller_user_id = seller_user_id;
    }

    public Integer getBuyer_user_id() {
        return buyer_user_id;
    }

    public void setBuyer_user_id(Integer buyer_user_id) {
        this.buyer_user_id = buyer_user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Date getTrade_time() {
        return trade_time;
    }

    public void setTrade_time(Date trade_time) {
        this.trade_time = trade_time;
    }

    public Integer getTrade_number() {
        return trade_number;
    }

    public void setTrade_number(Integer trade_number) {
        this.trade_number = trade_number;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
