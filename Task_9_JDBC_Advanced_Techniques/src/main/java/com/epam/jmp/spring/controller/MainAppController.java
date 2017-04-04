package com.epam.jmp.spring.controller;

import com.epam.jmp.spring.model.User;
import com.epam.jmp.spring.service.interfaces.ManageDatabaseFacadeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

/**
 * Created by Viachaslau_Marozau on 3/27/2017.
 */

@Controller
public class MainAppController
{

    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

    @RequestMapping(value = "/home")
    public String startPage()
    {
        return "start-page";
    }

    @RequestMapping(value = "/generateDatabase", method = RequestMethod.GET)
    public String generateDatabasePage()
    {
        return "generate-database";
    }

    @RequestMapping(value = "/generateDatabase", method = RequestMethod.POST)
    public String generateDatabase(@RequestParam String userNum, @RequestParam String friendshipNum, @RequestParam String postNum,
        @RequestParam String likeNum)
        throws ParseException
    {
        ManageDatabaseFacadeService manageDatabaseFacadeService = context
            .getBean("manageDatabaseFacadeService", ManageDatabaseFacadeService.class);
        int userNumAsInt = Integer.parseInt(userNum);
        int friendshipNumAsInt = Integer.parseInt(friendshipNum);
        int postNumAsInt = Integer.parseInt(postNum);
        int likeNumAsInt = Integer.parseInt(likeNum);
        manageDatabaseFacadeService.generateDatabase(userNumAsInt, friendshipNumAsInt, postNumAsInt, likeNumAsInt);
        return "generate-database-result";
    }

    @RequestMapping(value = "/selectFromDatabase", method = RequestMethod.GET)
    public String selectFromDatabasePage()
    {
        return "select-from-database";
    }

    @RequestMapping(value = "/selectFromDatabase", method = RequestMethod.POST)
    public ModelAndView  selectFromDatabase(@RequestParam String friendshipNum, @RequestParam String likeNum)
        throws ParseException
    {
        ManageDatabaseFacadeService manageDatabaseFacadeService = context
            .getBean("manageDatabaseFacadeService", ManageDatabaseFacadeService.class);
        int friendshipNumAsInt = Integer.parseInt(friendshipNum);
        int likeNumAsInt = Integer.parseInt(likeNum);
        User[] users = manageDatabaseFacadeService
            .searchUsersByFriendsAndLices(friendshipNumAsInt, likeNumAsInt);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("select-from-database-result");
        modelAndView.addObject("usersArray",users);
        return modelAndView;
    }

}
