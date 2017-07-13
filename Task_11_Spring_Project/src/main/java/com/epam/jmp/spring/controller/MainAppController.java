package com.epam.jmp.spring.controller;

import com.epam.jmp.spring.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainAppController
{

    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

    @RequestMapping(value = "/home")
    public String startPage()
    {
        return "start-page";
    }

    @RequestMapping(value = "/main")

    public String mainPage(@ModelAttribute User user)
    {
        if (user == null)
        {
            return "start-page";
        }
        else
        {
            return "main-page";
        }
    }

}
