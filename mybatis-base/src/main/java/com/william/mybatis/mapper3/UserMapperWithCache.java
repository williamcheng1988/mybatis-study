package com.william.mybatis.mapper3;

import com.william.domain.User;
import com.william.mybatis.mapper.Mapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.FifoCache;
import org.apache.ibatis.cache.decorators.LruCache;

/**
 * User: William Cheng
 * Create Time: 2018/9/1 20:24
 * Description:
 */
@CacheNamespace(
        eviction = FifoCache.class,
        flushInterval = 60000l,
        size = 512,
        readWrite = true
)
public interface UserMapperWithCache extends Mapper {
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