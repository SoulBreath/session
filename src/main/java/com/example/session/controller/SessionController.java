package com.example.session.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SessionController {

    @RequestMapping("/setSession")
    public Map<String,Object> setSession(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        // 将request Url 放入request的session域中
        request.getSession().setAttribute("msg",request.getRequestURL());
        map.put("request Url :", request.getRequestURL());
        return map;
    }

    @RequestMapping("/getSession")
    public Object getSession(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("sessionId",request.getSession().getId());
        map.put("msg",request.getSession().getAttribute("msg"));
        return map;
    }
}
