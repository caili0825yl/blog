package com.blog.Controller;

import com.blog.POJO.DO.UserDO;
import com.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
@CrossOrigin

public class UserController {
@Autowired
private UserService userService;

@RequestMapping("/userblogview")
public String userBlogView(){
       return "UserBlog";
}
    @RequestMapping("/registerview")
    public String registerView(){
        return "Register";
    }
    @RequestMapping("/loginview")
    public String loginview(){
        return "Login";
    }
    @ResponseBody
@PostMapping("/register")
    public void register(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password){
    UserDO userDO=new UserDO();
    userDO.setUsername(username);
    userDO.setPassword(password);
    userService.register(userDO);

       return ;
}

@ResponseBody
@PostMapping("/login")
    public String login(@RequestParam(name = "username")String username,@RequestParam(name = "password")String password){
       boolean exist=userService.login(username,password);
       if (exist){
           return "UserBlog";

       }else {
           return "Login";

       }
    }



}
