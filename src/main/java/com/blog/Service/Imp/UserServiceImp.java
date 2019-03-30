package com.blog.Service.Imp;

import com.blog.Dao.UserDOMapper;
import com.blog.POJO.DO.UserDO;
import com.blog.Service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired(required = false)
    private UserDOMapper userDOMapper;

    @Override
    public boolean login(String username, String password) {

        UserDO userDO=userDOMapper.selectByUsernameAndPassword(username,password);
        if(userDO==null){
            System.out.println("没有这个用户");
            System.out.println("false");
            return false;
        }else {
            System.out.println("true");
            return true;
        }


    }

    @Override
    public void register(UserDO userDO) {
        if(userDO==null){

        }

if(StringUtils.isEmpty(userDO.getUsername())||StringUtils.isEmpty(userDO.getPassword())){

        }
        try{
            userDOMapper.insert(userDO);

        }catch (DuplicateKeyException e){
            e.printStackTrace();
        }
        return;
    }
}
