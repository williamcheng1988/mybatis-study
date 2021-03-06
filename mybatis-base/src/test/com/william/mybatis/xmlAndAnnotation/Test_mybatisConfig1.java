package com.william.mybatis.xmlAndAnnotation;

import com.william.domain.User;
import com.william.mybatis.mapper2.UserMapperWithAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

@Slf4j
public class Test_mybatisConfig1 {
 
    public static void main(String[] args) throws IOException {
        //配置文件的名称
        String resource = "mybatis-config1.xml";
        //通过Mybatis包中的Resources对象很轻松的获取到配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //通过SqlSessionFactoryBuilder创建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //获得session实例
        SqlSession session = sqlSessionFactory.openSession(false);

        UserMapperWithAnnotation userMapper = session.getMapper(UserMapperWithAnnotation.class);
        User user = userMapper.select(5);
        System.out.println("selectUser:" + user.getUsername());
        log.info("查询得到用户信息：user:{}", user);

        //addUser(session);

        session.commit();
        session.close();
    }

    private static void addUser(SqlSession session) {
        User user = new User();
        user.setAge(10);
        user.setUsername("lisi");
        user.setPhone("186xXXX");
        user.setDesc("test");
        //完成数据库的插入
        session.insert("insert", user);
    }
}