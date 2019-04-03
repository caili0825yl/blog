package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
@MapperScan("com.blog.Dao")
public class BlogApplication {

@RequestMapping("/")

public String start(){
    return "Login";
}
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
