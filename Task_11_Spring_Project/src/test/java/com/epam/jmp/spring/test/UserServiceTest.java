package com.epam.jmp.spring.test;

import com.epam.jmp.spring.model.User;
import com.epam.jmp.spring.service.impl.UserServiceImpl;
import com.epam.jmp.spring.service.interfaces.UserService;
import org.junit.Assert;
import org.junit.Test;


public class UserServiceTest
{
    UserService userService;

    public void setUp(){
        userService = new UserServiceImpl();
    }

    @Test
    public void checkAddUserLogic(){
        User user = userService.getUser("testuser", "11111");
        Assert.assertNotNull(user);
    }
}
