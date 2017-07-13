package com.epam.jmp.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "TICKETS")
public class Ticket
{
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "USERID")
    private long userId;

    @Column(name = "EVENTID")
    private long eventId;

    @Column(name = "NUMBER")
    int number;

    @Column(name = "ROW")
    String row;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "CURRENCY")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "TICKETSTATUS")
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    public Ticket()
    {
        super();
    }

    public Ticket(long id, long userId, long eventId, int number, String row, BigDecimal amount,
        Currency currency, TicketStatus ticketStatus)
    {
        this.id = id;
        this.userId = userId;
        this.eventId = eventId;
        this.number = number;
        this.row = row;
        this.amount = amount;
        this.currency = currency;
        this.ticketStatus = ticketStatus;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public long getEventId()
    {
        return eventId;
    }

    public void setEventId(long eventId)
    {
        this.eventId = eventId;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getRow()
    {
        return row;
    }

    public void setRow(String row)
    {
        this.row = row;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public Currency getCurrency()
    {
        return currency;
    }

    public void setCurrency(Currency currency)
    {
        this.currency = currency;
    }

    public TicketStatus getTicketStatus()
    {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus)
    {
        this.ticketStatus = ticketStatus;
    }
}
