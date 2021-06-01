package com.campbell;

import com.campbell.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Campbell
 * @date 2020/10/5
 */
public class JDBCTest {

    @Test
    public void queryTest() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from users where username=? and password=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "zhangsan");
        ps.setString(2, "123");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int uid = resultSet.getInt("uid");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String nickname = resultSet.getString("nickname");
            System.out.println("uid:" + uid + "\t" + "username:" + username + "\t" + "password:" + password + "\t" + "nickname:" + nickname);
        }
        JDBCUtils.close(resultSet, ps, connection);
    }

    @Test
    public void addTest() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into users(username,password) values (?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "zhaoliu");
        ps.setString(2, "123");
        int result = ps.executeUpdate();
        System.out.println("result:" + result);
        JDBCUtils.close(null, ps, connection);
    }

    @Test
    public void updateTest() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "update users set password=? where username=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "123456");
        ps.setString(2, "zhaoliu");
        int result = ps.executeUpdate();
        System.out.println("result:" + result);
        JDBCUtils.close(null, ps, connection);
    }

    @Test
    public void deleteTest() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from users where username=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "zhaoliu");
        int result = ps.executeUpdate();
        System.out.println("result:" + result);
        JDBCUtils.close(null, ps, connection);
    }
}
