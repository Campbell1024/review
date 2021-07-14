package com.campbell.service.impl;

import com.campbell.entity.User;
import com.campbell.mapper.UserMapper;
import com.campbell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Campbell
 * @date 2021/7/13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean addUser(User user) {
        return userMapper.addUser(user) == 1;
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateUser(user) == 1;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return userMapper.deleteUserById(id) == 1;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUserListByIds(List<Integer> ids) {
        return userMapper.getUserListByIds(ids);
    }
}
