package com.kk.spring4shell.controller;

import com.kk.spring4shell.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class VulController {
    @RequestMapping("/hello")
    @ResponseBody
    public Object hello(User user){
        log.info("user:{}",user);
        return "ok<br>"+user;
    }


    @RequestMapping("/")
    public Object home(HttpServletRequest request, Model model){
        String url=request.getRequestURL().toString();
        model.addAttribute("url",url+"hello");
        return "index";
    }
}
