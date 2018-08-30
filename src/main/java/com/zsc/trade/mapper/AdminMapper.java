package com.zsc.trade.mapper;

import com.zsc.trade.bean.Admin;
import com.zsc.trade.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    @Select("select * from trade.admin")
    List<Admin> getList();


    @Insert("Insert into admin(password,adminName) values(#{password},#{adminName})")
    int insert(Admin user);


    @Delete("delete from admin where id = #{id}")
    void delete(Integer id);
}
