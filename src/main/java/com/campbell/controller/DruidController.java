package com.campbell.controller;

import com.campbell.util.DruidUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Campbell
 * @date 2020/10/7
 */
@RestController
@RequestMapping(value = "/test")
public class DruidController {

    @GetMapping(value = "/{uid}")
    public String get(@PathVariable(value = "uid") int uid){
        try {
            Connection connection = DruidUtils.getConnection();
            String sql = "select * from users where uid=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, uid);
            ResultSet rs = ps.executeQuery();
            String result = null;
            while (rs.next()){
                int id = rs.getInt("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                result = "uid:" + id + "\t" + "username:" + username + "\t" + "password:" + password + "\t" + "nickname:" + nickname;
            }
            DruidUtils.close(rs,ps,connection);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
