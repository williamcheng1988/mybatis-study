package com.william.mybatis.executor;


import com.william.mybatis.binding.MapperMethod;
import com.william.mybatis.session.Configuration;
import com.william.mybatis.statement.StatementHandler;

public class SimpleExecutor implements Executor {
    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T query(MapperMethod method, Object parameter) throws Exception {
        StatementHandler statementHandler = new StatementHandler(configuration);
        return statementHandler.query(method, parameter);
    }
}
