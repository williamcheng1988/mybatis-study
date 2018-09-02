package com.william.jdbc;

import com.william.domain.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * 面向对象
 */
@Slf4j
public class JdbcTest {

    public static void main(String[] args) {
        User c = new User();
        c.setUsername("wukong");
        c.setAge(18);
        insert(c);
        //查询
        c = query(1);
        log.info("userid:{},name:{}", c.getId(), c.getUsername());
    }

    static void insert(User c) {
        String sql = "insert into user(username,age) value(?,?)";
        Connection conn = DbUtil.open();
        try {
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, c.getUsername());
            pstmt.setInt(2, c.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn);
        }
    }

    static User query(int id) {
        String sql = "select * from user where id=?";
        Connection conn = DbUtil.open();
        try {
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                User c = new User();
                c.setId(id);
                c.setUsername(name);
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn);
        }
        return null;
    }

}
