package com.william.mybatis.xmlAndAnnotation;

import com.william.domain.User;
import com.william.mybatis.mapper2.UserMapperWithAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test_mybatisConfig3 {
 
    public static void main(String[] args) throws IOException {
        //配置文件的名称
        String resource = "mybatis-config3.xml";
        //通过Mybatis包中的Resources对象很轻松的获取到配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //通过SqlSessionFactoryBuilder创建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //获得session实例
        SqlSession session = sqlSessionFactory.openSession();

        UserMapperWithAnnotation userMapper = session.getMapper(UserMapperWithAnnotation.class);
        User user = userMapper.select(4);
        System.out.println("selectUser:" + user.getUsername());

        session.commit();
        session.close();
    }
}