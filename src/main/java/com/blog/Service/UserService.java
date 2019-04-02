package com.blog.Service;

import com.blog.POJO.DO.UserDO;

import java.util.List;

public interface UserService {
    UserDO login(String username,String password);
    boolean register(UserDO userDO);
    UserDO check(String username,String tel);
    void change(UserDO userDO);
    UserDO getUser(String username);

}
