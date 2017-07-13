package com.epam.jmp.spring.controller;

import com.epam.jmp.spring.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
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
    public String addUser(@RequestParam String login, @RequestParam String password, @RequestParam String role,
        @RequestParam String name, @RequestParam String surname, @RequestParam String email,
        @RequestParam String phone, @RequestParam String birthdate) throws ParseException
    {
        userService.addUser();
        return null;
    }

}
