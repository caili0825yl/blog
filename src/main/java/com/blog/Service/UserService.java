package com.blog.Service;

import com.blog.POJO.DO.UserDO;

public interface UserService {
    boolean login(String username,String password);
    void register(UserDO userDO);
}
