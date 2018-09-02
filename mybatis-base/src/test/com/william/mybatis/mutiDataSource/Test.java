package com.william.mybatis.mutiDataSource;

import com.william.domain.User;
import com.william.mybatis.mapper.UserMapper;
import com.william.mybatis.mapper2.UserMapperWithAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * User: William Cheng
 * Create Time: 2018/9/2 14:37
 * Description:
 */
@Slf4j
public class Test {

    public static void main(String[] args) throws IOException {
        //配置文件的名称
        String resource = "mybatis-config4.xml";
        //通过Mybatis包中的Resources对象很轻松的获取到配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //通过SqlSessionFactoryBuilder创建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "DEV");
        SqlSession session = sqlSessionFactory.openSession();
        UserMapperWithAnnotation userMapper = session.getMapper(UserMapperWithAnnotation.class);
        User user = userMapper.select(4);
        log.info("user:{}", user);
    }
}