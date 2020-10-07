package com.campbell.service;

import com.campbell.utils.DruidUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Campbell
 * @date 2020/10/6
 */
public class DruidTest {

    @Test
    public void queryTest() throws SQLException {
        Connection connection = DruidUtils.getConnection();
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
        DruidUtils.close(resultSet, ps, connection);
    }
}
