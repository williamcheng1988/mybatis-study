package com.william.mybatis.session;


import com.william.mybatis.binding.MapperMethod;

public interface SqlSession {
    <T> T selectOne(MapperMethod mapperMethod, Object statement) throws Exception;

}
