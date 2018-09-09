package com.william.mybatis.binding;


import com.william.mybatis.session.DefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy<T> implements InvocationHandler {

    private final DefaultSqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(DefaultSqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperMethod mapperMethod = sqlSession.getConfiguration().getMapperRegistry().getKnownMappers().get(method
                .getDeclaringClass().getName() + "." + method.getName());
        if (null != mapperMethod) {
            return sqlSession.selectOne(mapperMethod, String.valueOf(args[0]));
        }
        return method.invoke(proxy, args);
    }
}
