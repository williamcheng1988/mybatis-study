package com.william.mybatis.annotationWithoutXml;

import com.william.domain.User;
import com.william.mybatis.mapper2.UserMapperWithAnnotation;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * User: William Cheng
 * Create Time: 2018/9/1 19:55
 * Description:
 */
public class Test {


    public static void main(String[] args) {
        /*
         * 无xml方式进行构建  SqlSessionFactory
         */
        String driver = "com.mysql.jdbc.Driver";//需要的数据库驱动
        String url = "jdbc:mysql://localhost:3306/tl-vip";//数据库名路径
        String username = "root";
        String password = "root";
        javax.sql.DataSource dataSource = new PooledDataSource(driver, url, username, password);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        org.apache.ibatis.mapping.Environment environment = new org.apache.ibatis.mapping.Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapperWithAnnotation.class);
        //configuration.addMappers("com.william.mybatis.mapper2");
        //configuration.addMappers("com.william.mybatis.mapper2", UserMapperWithAnnotation.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User();
        user.setAge(10);
        user.setUsername("zhangsan1");
        user.setPhone("186xXXX");
        user.setDesc("test");
        session.insert("insert", user);
        session.commit();
        session.close();
    }
}