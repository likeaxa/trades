package com.zsc.trade.mapper;

import com.zsc.trade.bean.Category;
import com.zsc.trade.bean.ExchSerach;
import com.zsc.trade.bean.Exchange;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeMapper {

    /**
     * private Integer id;
     * private Integer seller_user_id;
     * private Integer buyer_user_id;
     * private Integer product_id;
     * private String trade_time;
     * private Integer trade_number;
     * private double total;
     * private Integer status;
     */

    @Select("select * from exchange")
    List<Exchange> getAll();

    @Update("update exchange set " +
            "seller_user_id=#{seller_user_id}, " +
            "buyer_user_id=#{buyer_user_id}, " +
            "product_id=#{product_id}," +
            "trade_time=#{trade_time}," +
            "trade_number=#{trade_number}," +
            "total=#{total}," +
            "status=#{status}" +
            "where id=#{id}")
    void update(Exchange exchange);

    @Delete("delete from exchange where id = #{id}")
    void delete(Integer id);

    @Select("select * from exchange " +
            "WHERE buyer_user_id=#{user_id}" +
            "and DATE_FORMAT(trade_time,'%Y-%m-%d') " +
            "BETWEEN #{start_date}" +
            "and #{list_date}")
    List<Exchange> getBuySearch(ExchSerach exchSerach);

    @Select("select * from exchange " +
            "WHERE seller_user_id=#{user_id}" +
            "and DATE_FORMAT(trade_time,'%Y-%m-%d') " +
            "BETWEEN #{start_date}" +
            "and #{list_date}")
    List<Exchange> getSellerSearch(ExchSerach exchSerach);
}
