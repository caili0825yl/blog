package com.blog.Service;

import com.blog.POJO.DO.UserDO;

import java.util.List;

public interface UserService {
    UserDO login(String username,String password);  //登陆功能
    boolean register(UserDO userDO); //注册功能
    UserDO check(String username,String tel);//改密码时验证
    void change(UserDO userDO);//修改密码
    UserDO getUser(String username);//查询用户
    void editData(UserDO userDO);//修改资料
}
