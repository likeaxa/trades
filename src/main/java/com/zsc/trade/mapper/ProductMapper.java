package com.zsc.trade.mapper;

import com.zsc.trade.bean.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    /**
     * private Integer id;
     * private String name;
     * private String price;
     * private String gmt_create;
     * private String description;
     * private Integer cate_id;
     * private Integer number;
     */
    @Select("select * from product where name like CONCAT(CONCAT('%', #{name}),'%')")
    List<Product> getSimpleProductByName(String name);

    @Select("select * from product")
    List<Product> getAll();

    @Select("select * from product where cate_id=#{id}")
    List<Product> getProduceById(Integer id);

    @Insert("insert into product(name ,price,gmt_create,description,cate_id,number) " +
            "values ( #{name},#{price},#{gmt_create},#{description},#{cate_id},#{number})")
    int Insert(Product produce);

    @Update("update product set name=#{name},price=#{price},gmt_create=#{gmt_create}," +
            "description=#{description},cate_id=#{cate_id},number=#{number} where id=#{id}")
    void update(Product product);

    @Delete("delete from product where id=#{id}")
    void delete(Integer id);
}