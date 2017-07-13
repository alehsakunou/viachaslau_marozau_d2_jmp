package com.epam.jmp.spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainAppController
{

    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

    @RequestMapping(value = "/home")
    public String startPage()
    {
        return "start-page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage()
    {
        return "login-page";
    }
}
