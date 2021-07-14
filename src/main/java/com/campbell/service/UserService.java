package com.campbell.service;

import com.campbell.entity.User;

import java.util.List;

/**
 * @author Campbell
 * @date 2021/7/13
 */
public interface UserService {

    Boolean addUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUserById(Integer id);

    User getUserById(Integer id);

    List<User> getUserListByIds(List<Integer> ids);
}
