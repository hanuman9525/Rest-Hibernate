package com.scp.dao;

import java.util.List;

import com.scp.bean.User;

public interface UserDao {
public String addUser(User user);
public User getUser(String userId);
public List<User> getAllUser();;
}
