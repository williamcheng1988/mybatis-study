package com.william.mybatis.xml;

import com.william.domain.User;
import com.william.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
 
public class Test_mybatisConfig {
 
    public static void main(String[] args) throws IOException {
        //配置文件的名称
        String resource = "mybatis-config.xml";
        //通过Mybatis包中的Resources对象很轻松的获取到配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //通过SqlSessionFactoryBuilder创建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //获得session实例
        SqlSession session = sqlSessionFactory.openSession();

//        addUser(session);
//        selectUser(session);
        selectUser2(session);

        session.commit();
        session.close();
    }

    private static void addUser(SqlSession session) {
        User user = new User();
        user.setAge(10);
        user.setUsername("zhangsan");
        user.setPhone("186xXXX");
        user.setDesc("test");
        //完成数据库的插入
        session.insert("insert", user);
    }

    private static void selectUser(SqlSession session) {
        User user = (User) session.selectOne("com.william.mybatis.mapper.UserMapper.select", 4);
        System.out.println("selectUser:" + user.getUsername());
    }

    private static void selectUser2(SqlSession session) {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.select(4);
        System.out.println("selectUser2:" + user.getUsername());
    }
}