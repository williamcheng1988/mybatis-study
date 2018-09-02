package com.william.mybatis.mapper;

import com.william.domain.User;

/**
 * User: William Cheng
 * Create Time: 2018/9/1 20:24
 * Description:
 */
public interface UserMapper extends Mapper {

    int insert(User user);

    User select(int id);

}