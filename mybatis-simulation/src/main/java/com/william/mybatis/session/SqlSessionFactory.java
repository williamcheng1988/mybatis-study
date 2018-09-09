package com.william.mybatis.session;


import com.william.mybatis.executor.SimpleExecutor;

public class SqlSessionFactory {


    public SqlSession openSession(Configuration configuration) {
        return new DefaultSqlSession(configuration, new SimpleExecutor(configuration));
    }

}
