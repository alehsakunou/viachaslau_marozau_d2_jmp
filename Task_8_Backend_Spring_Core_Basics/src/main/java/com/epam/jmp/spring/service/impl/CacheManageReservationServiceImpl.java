package com.epam.jmp.spring.service.impl;

import com.epam.jmp.spring.model.Reservation;
import com.epam.jmp.spring.service.interfaces.ManageReservationService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Viachaslau_Marozau on 3/27/2017.
 */
public class CacheManageReservationServiceImpl implements ManageReservationService
{
    private Map<String, Reservation> cache = new HashMap<String, Reservation>();

    @Override
    public Reservation addReservation(Reservation reservation)
    {
        return cache.put(reservation.getReservationId(), reservation);
    }
}
