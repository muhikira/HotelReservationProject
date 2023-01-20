package com.muhikira.hotelReservation.service;

import com.muhikira.hotelReservation.entity.Reservation;
import com.muhikira.hotelReservation.requestBooking.ReservationRequest;

import java.util.List;

public interface ReservationService {
    public List<Reservation> getAll();
    Reservation getReservationById(int theId) throws Exception;
    public Reservation save(ReservationRequest reservationRequest) throws IllegalAccessException;
    public void deleteById(int ReservationId);
}
