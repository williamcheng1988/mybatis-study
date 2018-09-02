package com.william.mybatis.mapper2;

import com.william.domain.User;
import com.william.mybatis.mapper.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * User: William Cheng
 * Create Time: 2018/9/1 20:24
 * Description:
 */
public interface UserMapperWithAnnotation extends Mapper {
    @Results(
            id = "",
            value = {
                    @Result(property = "myDesc", column = "desc")
            })
    @Select("select id,username,age,phone,`desc` from user where id=#{id}")
    User select(int id);

    @Insert("insert into user (username, age, phone,`desc`)" +
            "values (#{username,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, #{phone,jdbcType=BIGINT}, #{desc,jdbcType=VARCHAR})")
    int insert(User user);

}