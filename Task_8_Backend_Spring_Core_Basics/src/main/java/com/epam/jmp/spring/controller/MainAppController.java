package com.epam.jmp.spring.controller;

import com.epam.jmp.spring.model.Customer;
import com.epam.jmp.spring.model.Place;
import com.epam.jmp.spring.model.Price;
import com.epam.jmp.spring.model.Reservation;
import com.epam.jmp.spring.service.interfaces.ManageReservationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Viachaslau_Marozau on 3/27/2017.
 */

@Controller
public class MainAppController
{

    private static ApplicationContext context = new ClassPathXmlApplicationContext("contextFile.xml");

    @RequestMapping(value = "/home")
    public String startPage()
    {
        return "start-page";
    }

    @RequestMapping(value = "/addReservation", method = RequestMethod.GET)
    public String addReservationForm()
    {
        return "add-reservation";
    }

    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    public String addReservation(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String movieTitle,
        @RequestParam String movieDate, @RequestParam String number, @RequestParam String row, @RequestParam String price)
        throws ParseException
    {
        Customer customer = new Customer(firstName, lastName);
        int numberAsInt = Integer.parseInt(number);
        Place place = new Place(numberAsInt, row);
        long priceAsLong = (long) (Double.parseDouble(price) + 100);
        Price resPrice = new Price(priceAsLong, "BYN");
        String reservationId = movieTitle + movieDate + row + number;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd hh:mm");
        Date docDate = format.parse(movieDate);
        Reservation reservation = new Reservation(reservationId, movieTitle, docDate, place, resPrice,
            customer);
        ManageReservationService manageReservationService = context
            .getBean("ManageReservationService", ManageReservationService.class);
        manageReservationService.addReservation(reservation);
        return "add-reservation-result";
    }
}
