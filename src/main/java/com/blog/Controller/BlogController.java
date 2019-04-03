package com.blog.Controller;

import com.blog.POJO.DO.EssayDO;
import com.blog.POJO.DO.UserDO;
import com.blog.POJO.VO.UserVO;
import com.blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "true")
public class BlogController {
    @Autowired
    private BlogService blogService;
@Autowired
private HttpSession httpSession;
    @ResponseBody
    @RequestMapping("/getlist")  //用户获取日志列表
    public List<EssayDO> getList() {
        List<EssayDO> essayList=blogService.getEssayList(((UserVO)httpSession.getAttribute("USER")).getUsername());

        return essayList;
}

    @ResponseBody
    @RequestMapping("/visitorgetlist") //游客获取日志列表
    public List<EssayDO> visitorGetList() {
        List<EssayDO> essayList=blogService.getEssayList(((String)httpSession.getAttribute("search")));

        return essayList;
    }
@RequestMapping("/writecontent") //写日志
    public String writecontent(@RequestParam(name = "title") String title,@RequestParam(name = "text") String text){
        EssayDO essayDO=new EssayDO();
        essayDO.setTitle(title);
        essayDO.setUserName(((UserVO)httpSession.getAttribute("USER")).getUsername());
        essayDO.setContent(text);
        blogService.write(essayDO);
        return "UserBlog";
}
    @RequestMapping("/myblog") //跳转页面
    public String myBlog(){

        return "UserBlog";
    }
    @RequestMapping("/write") //跳转页面
    public String write(){

        return "WriteContent";
    }
@ResponseBody
@RequestMapping("/read") //阅读日志
    public EssayDO read(@RequestParam(name = "id") Long id){
    EssayDO  essayDO=blogService.read(id);
    return essayDO;
}
    @RequestMapping("/visitorblog") //游客浏览博客
    public String visitorBlog(@RequestParam(name = "id") Long id){

        return "VisitorBlog";
    }
    @RequestMapping("/getcontent") //跳转页面
    public String getcontent(@RequestParam(name = "id") Long id){

        return "GetContent";
    }
    @RequestMapping("/visitorgetcontent") //跳转页面
    public String visitorGetContent(@RequestParam(name = "id") Long id){

        return "VisitorGetContent";
    }
    @ResponseBody
    @RequestMapping("/edit") //编辑日志
    public boolean edit(@RequestParam(name = "id") Long id,@RequestParam(name = "title") String title,@RequestParam(name = "content") String content){
        EssayDO essayDO=new EssayDO();
        essayDO.setId(id);
        essayDO.setTitle(title);
        essayDO.setContent(content);
        blogService.edit(essayDO);
        return true;
    }

    @ResponseBody
    @RequestMapping("/delete") //删除日志
    public boolean delete(@RequestParam(name = "id") Long id){
        EssayDO essayDO=new EssayDO();

        blogService.delete(id);
        return true;
    }
    @RequestMapping("/quit") //退出账号
    public String quit(){
        httpSession.invalidate();
        return "Login";
    }
}
