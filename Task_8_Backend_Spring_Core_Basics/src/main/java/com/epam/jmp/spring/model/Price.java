package com.epam.jmp.spring.model;

/**
 * Created by Viachaslau_Marozau on 3/27/2017.
 */
public class Price
{
    private String currency;
    private long price;

    public Price()
    {
        super();
    }

    public Price(long price, String currency)
    {
        this.currency = currency;
        this.price = price;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public long getPrice()
    {
        return price;
    }

    public void setPrice(long price)
    {
        this.price = price;
    }
}
