package com.example.spring_store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String name;
    @RequestMapping("/")
    public String index(){
        System.out.println(name+"------->");
        String viewName= getViewName();
       return viewName;
    }

    private String getViewName(){
        return "index.html";
    }

}
