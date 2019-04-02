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
    @RequestMapping("/getlist")
    public List<EssayDO> getList() {
        List<EssayDO> essayList=blogService.getEssayList(((UserVO)httpSession.getAttribute("USER")).getUsername());

        return essayList;
}

    @ResponseBody
    @RequestMapping("/visitorgetlist")
    public List<EssayDO> visitorGetList() {
        List<EssayDO> essayList=blogService.getEssayList(((String)httpSession.getAttribute("search")));

        return essayList;
    }
@RequestMapping("/writecontent")
    public String writecontent(@RequestParam(name = "title") String title,@RequestParam(name = "text") String text){
        EssayDO essayDO=new EssayDO();
        essayDO.setTitle(title);
        essayDO.setUserName(((UserVO)httpSession.getAttribute("USER")).getUsername());
        essayDO.setContent(text);
        blogService.write(essayDO);
        return "UserBlog";
}
    @RequestMapping("/myblog")
    public String myBlog(){

        return "UserBlog";
    }
    @RequestMapping("/write")
    public String write(){

        return "WriteContent";
    }
@ResponseBody
@RequestMapping("/read")
    public EssayDO read(@RequestParam(name = "id") Long id){
    EssayDO  essayDO=blogService.read(id);
    return essayDO;
}
    @RequestMapping("/visitorblog")
    public String visitorBlog(@RequestParam(name = "id") Long id){

        return "VisitorBlog";
    }
    @RequestMapping("/getcontent")
    public String getcontent(@RequestParam(name = "id") Long id){

        return "GetContent";
    }
    @RequestMapping("/visitorgetcontent")
    public String visitorGetContent(@RequestParam(name = "id") Long id){

        return "VisitorGetContent";
    }
    @ResponseBody
    @RequestMapping("/edit")
    public boolean edit(@RequestParam(name = "id") Long id,@RequestParam(name = "title") String title,@RequestParam(name = "content") String content){
        EssayDO essayDO=new EssayDO();
        essayDO.setId(id);
        essayDO.setTitle(title);
        essayDO.setContent(content);
        blogService.edit(essayDO);
        return true;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public boolean delete(@RequestParam(name = "id") Long id){
        EssayDO essayDO=new EssayDO();

        blogService.delete(id);
        return true;
    }
    @RequestMapping("/quit")
    public String quit(){
        httpSession.invalidate();
        return "Login";
    }
}
