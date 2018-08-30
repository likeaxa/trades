package com.zsc.trade.mapper;

import com.zsc.trade.bean.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeMapper {

    /**
     * private Integer id;
     * private Integer user_id;
     * private Integer product_id;
     */

    @Select("select * from user_id=#{user_id}")
    List<Like> getLikeByUid(Integer user_id);

    @Insert("insert into like(user_id,product_id) values( #{user_id},#{product_id})")
    int insert(Like like);

    @Update("update like set user_id = #{user_id},product_id=#{product_id} where id=#{id}")
    void update(Like like);

    @Delete("delete like from id = #{id}")
    void delete(Integer id);

}
