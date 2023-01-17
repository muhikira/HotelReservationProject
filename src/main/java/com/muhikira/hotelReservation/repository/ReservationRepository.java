package com.muhikira.hotelReservation.repository;

import com.muhikira.hotelReservation.entity.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <Reservation, Integer> {


}
