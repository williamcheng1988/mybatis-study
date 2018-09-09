package com.william.mybatis.executor;


import com.william.mybatis.binding.MapperMethod;


public interface Executor {

    <T> T query(MapperMethod method, Object parameter) throws Exception;
}
