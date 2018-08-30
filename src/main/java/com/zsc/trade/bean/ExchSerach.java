package com.zsc.trade.bean;

import java.util.Date;

public class ExchSerach {
    /**
     * start_date:start_date,
     * list_date:list_date,
     * user_id:user_id,
     * select:select
     */
    private String start_date;
    private String list_date;
    private Integer user_id;
    private String select;
    private Integer start;
    private Date List_time;

    public Date getList_time() {
        return List_time;
    }

    public void setList_time(Date list_time) {
        List_time = list_time;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getList_date() {
        return list_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setList_date(String list_date) {
        this.list_date = list_date;
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    @Override
    public String toString() {
        return "ExchSerach{" +
                "start_date=" + start_date +
                ", list_date=" + list_date +
                ", user_id=" + user_id +
                ", select='" + select + '\'' +
                ", start=" + start +
                '}';
    }
}
