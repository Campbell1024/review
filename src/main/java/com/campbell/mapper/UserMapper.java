package com.campbell.mapper;

import com.campbell.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Campbell
 * @date 2021/7/13
 */
public interface UserMapper {

    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUserById(Integer id);

    User getUserById(Integer id);

    List<User> getUserListByIds(@Param("ids") List<Integer> ids);

}
