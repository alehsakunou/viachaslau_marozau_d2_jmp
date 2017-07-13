package com.epam.jmp.spring.controller;

import com.epam.jmp.spring.model.Role;
import com.epam.jmp.spring.model.User;
import com.epam.jmp.spring.model.UserInfo;
import com.epam.jmp.spring.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.ParseException;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserAppController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUserPage() throws ParseException
    {
        return "add-user-page";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String login, @RequestParam String password,
        @RequestParam String name, @RequestParam String surname, @RequestParam String email,
        @RequestParam String phone, @RequestParam String birthdate) throws ParseException
    {
        Timestamp birthdateAsDate = Timestamp.valueOf(birthdate);
        Role roleAsEnum = Role.USER;
        UserInfo userInfo = userService.addUserInfo(name, surname, email, phone, birthdateAsDate);
        User user = userService.addUser(login, password, roleAsEnum, userInfo.getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main-page");
        modelAndView.addObject("user",user);
        modelAndView.addObject("userInfo",userInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String addUser() throws ParseException
    {
        return "login-page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String login, @RequestParam String password) throws ParseException
    {
        User user = userService.getUser(login, password);
        UserInfo userInfo = userService.getUserInfo(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main-page");
        modelAndView.addObject("user",user);
        modelAndView.addObject("userInfo",userInfo);
        return modelAndView;
    }
}
