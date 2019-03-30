package com.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
@Controller
@RequestMapping("/blog")
@CrossOrigin
public class BlogController {
    @ResponseBody
    @RequestMapping("/getlist")
    public ArrayList<String> getList() {
        ArrayList<String> a=new ArrayList<>();
        a.add("fdsaf");
        a.add("fdas");
        return a ;


    }

}
