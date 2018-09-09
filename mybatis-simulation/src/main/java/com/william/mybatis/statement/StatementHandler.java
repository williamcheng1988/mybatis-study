package com.william.mybatis.statement;

import com.william.mybatis.binding.MapperMethod;
import com.william.mybatis.result.DefaultResultSetHandler;
import com.william.mybatis.result.ResultSetHandler;
import com.william.mybatis.session.Configuration;
import com.william.mybatis.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StatementHandler {
    private Configuration configuration;

    private ResultSetHandler resultSetHandler;

    public StatementHandler() {
    }

    public StatementHandler(Configuration configuration) {
        this.configuration = configuration;
        resultSetHandler = new DefaultResultSetHandler();
    }

    public <T> T query(MapperMethod method, Object parameter) throws Exception {

        Connection connection = DbUtil.open();
        PreparedStatement preparedStatement = connection.prepareStatement(String.format(method.getSql(), Integer.parseInt(String
                .valueOf(parameter))));
        preparedStatement.execute();
        return resultSetHandler.handle(preparedStatement, method);
    }
}
