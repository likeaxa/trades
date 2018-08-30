package com.zsc.trade.mapper;

import com.zsc.trade.bean.Image;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageMapper {

    /**
     * private Integer id;
     * private Integer product_id;
     * private Integer type;
     */
    @Select("select * from image where product_id = #{product_id}")
    List<Image> getImageByPid(Integer pid);

    @Select("select * from image where id = #{id}")
    Image getImage(Integer id);

    @Insert("insert into image(product_id,link) values (#{product_id},#{link})")
    int insert(Image image);

    @Update("update image set product_id={product_id},link = #{link} where id = #{id}")
    void update(Image image);

    @Delete("delete from image where id=#{id}")
    void delete(Integer id);

}
