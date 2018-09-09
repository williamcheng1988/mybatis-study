package com.william.mybatis.mapper3;

import com.william.domain.User;
import com.william.mybatis.cache.MybatisRedisCache;
import com.william.mybatis.mapper.Mapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.FifoCache;

/**
 * User: William Cheng
 * Create Time: 2018/9/1 20:24
 * Description:
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface UserMapperWithCache2 extends Mapper {
    @Results(
            id = "",
            value = {
                    @Result(property = "myDesc", column = "desc")
            })
    @Select("select id,username,age,phone,`desc` from user where id=#{id}")
    @Flush
    User select(int id);

    @Insert("insert into user (username, age, phone,`desc`)" +
            "values (#{username,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, #{phone,jdbcType=BIGINT}, #{desc,jdbcType=VARCHAR})")
    int insertUser(User user);

}