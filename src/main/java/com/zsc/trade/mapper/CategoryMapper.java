package com.zsc.trade.mapper;

import com.zsc.trade.bean.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    @Select("select * from category")
    List<Category> getAll();

    @Select("select * from category where id=#{id}")
    Category getCategoryById(Integer id);

    @Insert("insert into category(cate_name) values(#{cate_name})")
    int insert(Category category);

    @Update("update category set cate_name=#{cate_name} where id=#{id}")
    void update(Category category);

    @Delete("delete from category where id = #{id}")
    void delete(Integer id);
}
