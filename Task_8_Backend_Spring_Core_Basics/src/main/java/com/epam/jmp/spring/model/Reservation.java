package com.epam.jmp.spring.model;

import java.util.Date;

/**
 * Created by Viachaslau_Marozau on 3/27/2017.
 */
public class Reservation
{

    private String reservationId;
    private String movieTitle;
    private Date movieDate;
    private Place place;
    private Price price;
    private Customer customer;

    public Reservation()
    {
        super();
    }

    public Reservation(String reservationId, String movieTitle, Date movieDate, Place place, Price price,
        Customer customer)
    {
        this.reservationId = reservationId;
        this.movieTitle = movieTitle;
        this.movieDate = movieDate;
        this.place = place;
        this.price = price;
        this.customer = customer;
    }

    public String getReservationId()
    {
        return reservationId;
    }

    public void setReservationId(String reservationId)
    {
        this.reservationId = reservationId;
    }

    public String getMovieTitle()
    {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle)
    {
        this.movieTitle = movieTitle;
    }

    public Date getMovieDate()
    {
        return movieDate;
    }

    public void setMovieDate(Date movieDate)
    {
        this.movieDate = movieDate;
    }

    public Place getPlace()
    {
        return place;
    }

    public void setPlace(Place place)
    {
        this.place = place;
    }

    public Price getPrice()
    {
        return price;
    }

    public void setPrice(Price price)
    {
        this.price = price;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
