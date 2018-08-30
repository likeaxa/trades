package com.zsc.trade.mapper;


import com.zsc.trade.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from user where username like CONCAT(CONCAT('%', #{name}),'%')")
    List<User> getSimpleUserByName(String name);

    @Select("select * from user ")
    List<User> getList();

    @Select("select * from user where id=#{id}")
    User getUserById(Integer id);

    @Insert("Insert into user(username,password,phone,address,star) values(#{username},#{password},#{phone},#{address},#{star})")
    int insert(User user);

    @Update("update user set username=#{username},password=#{password},phone=#{phone} ,address = #{address},star=#{star}where id=#{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void delete(Integer id);


}
