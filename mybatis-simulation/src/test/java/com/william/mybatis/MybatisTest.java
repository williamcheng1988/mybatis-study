package com.william.mybatis;

import static org.junit.Assert.assertTrue;

import com.william.mybatis.domain.User;
import com.william.mybatis.mapper.UserMapper;
import com.william.mybatis.session.Configuration;
import com.william.mybatis.session.DefaultSqlSession;
import com.william.mybatis.session.SqlSessionFactory;
import com.william.mybatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class MybatisTest {


    @Test
    public void testMybatisMock() throws IOException {
        InputStream inputStream = MybatisTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");

        Configuration configuration = new Configuration();
        configuration.setInputStream(inputStream);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        DefaultSqlSession sqlSession = (DefaultSqlSession) sqlSessionFactory.openSession(configuration);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select(4);
        System.out.println(user);

    }
}
