package com.william.mybatis.result;


import com.william.mybatis.binding.MapperMethod;

import java.sql.PreparedStatement;

public interface ResultSetHandler {

    public <T> T handle(PreparedStatement pstmt, MapperMethod mapperMethod) throws Exception;
}
