package com.blog.Controller;

import com.blog.POJO.DO.UserDO;
import com.blog.POJO.VO.UserVO;
import com.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Controller
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "true")

public class UserController {
@Autowired
private UserService userService;
@Autowired
private HttpSession httpSession;

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
    public boolean register(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password,
                            @RequestParam(name = "tel") String tel,@RequestParam(name = "nickname") String nickname){
    boolean check=false;
    String base64password= Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
    UserDO userDO=new UserDO();
    userDO.setUsername(username);
    userDO.setPassword(base64password);
    userDO.setTel(tel);
    userDO.setNickname(nickname);
       check= userService.register(userDO);
        return  check;


}

@ResponseBody
@PostMapping("/login")
    public boolean login(@RequestParam(name = "username")String username,@RequestParam(name = "password")String password){
       boolean exist=false;
    String base64password= Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
       UserDO userDO=userService.login(username,base64password);
       if(userDO==null){
           exist=false;
       }else
       {
           exist=true;
       }
       if (exist){

           UserVO userVO=new UserVO();
           userVO.setUsername(userDO.getUsername());
           userVO.setNickname(userDO.getNickname());
           userVO.setSign(userDO.getSign());

           httpSession.setAttribute("IS_LOGIN",true);
           httpSession.setAttribute("USER",userVO);

           return true;

       }else {

           return false;

       }
    }

    @RequestMapping("/forget")
    public String  forget(){

        return  "Forget";

    }
    @RequestMapping("/changepage")
    public String  changePage(){

        return  "Change";

    }

    @RequestMapping("/loginpage")
    public String  loginPage(){

        return  "Login";

    }
@ResponseBody
@PostMapping("/check")
    public boolean  check(@RequestParam(name = "username") String username,@RequestParam(name = "tel") String tel){

    UserDO userDO=userService.check(username,tel);
   if(userDO==null){
       return false;
   }else {
       httpSession.setAttribute("changePass",userDO.getId());
       return true;
   }
    }
    @ResponseBody
    @PostMapping("/change")
    public boolean  change(@RequestParam(name = "password") String password){
        UserDO userDO=new UserDO();
        String base64password= Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));

        userDO.setId((Long) (httpSession.getAttribute("changePass")));
        userDO.setPassword(base64password);
        userService.change(userDO);
        return true;
    }

    @ResponseBody
    @RequestMapping("/getuser")
    public UserVO getUser(){
    String username=(String)httpSession.getAttribute("search");
    UserVO userVO=new UserVO();
            UserDO userDO=userService.getUser(username);
            if(userDO==null){
                return null;
            }else{

                    userVO.setUsername(userDO.getUsername());
                    userVO.setId(userDO.getId());
                    userVO.setNickname(userDO.getNickname());
                    userVO.setSign(userDO.getSign());
                return userVO;
            }
    }
@ResponseBody
    @RequestMapping("/search")
    public boolean search(@RequestParam(name = "search")String username){
        if(userService.getUser(username)==null){
            return false;
        }else {

            httpSession.setAttribute("search", username);
            return true;
        }
    }
    @RequestMapping("/searchview")
    public String searchView() {

        return "SearchUser";

    }
}
