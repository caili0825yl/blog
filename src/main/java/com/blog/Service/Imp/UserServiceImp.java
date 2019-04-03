package com.blog.Service.Imp;

import com.blog.Dao.UserDOMapper;
import com.blog.POJO.DO.UserDO;
import com.blog.Service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired(required = false)
    private UserDOMapper userDOMapper;

    @Override
    public UserDO login(String username, String password) {

        UserDO userDO=userDOMapper.selectByUsernameAndPassword(username,password);
        if(userDO==null){

            return null;
        }else {

            return userDO;
        }


    }

    @Override
    public boolean  register(UserDO userDO) {



        try{
            userDOMapper.insert(userDO);

        }catch (DuplicateKeyException e){
            return false;
        }
        return true;
    }

    @Override
    public UserDO check(String username, String tel) {
        UserDO userDO=userDOMapper.selectByUsernameAndTel(username,tel);
        if (userDO==null){
            return null;
        }else {
            return userDO;
        }
    }

    @Override
    public void change(UserDO userDO) {
        userDOMapper.updateById(userDO);
        return;
    }

    @Override
    public UserDO getUser(String username) {
        UserDO userDO=userDOMapper.selectByUsername(username);
        if(userDO==null){
            return null;
        }else{
            return userDO;
        }

    }

    @Override
    public void editData(UserDO userDO) {
        userDOMapper.updateDataById(userDO);
        return;
    }
}
