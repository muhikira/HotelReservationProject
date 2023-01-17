package com.muhikira.hotelReservation.controller;

import com.muhikira.hotelReservation.entity.HotelRoom;
import com.muhikira.hotelReservation.entity.Reservation;
import com.muhikira.hotelReservation.repository.ReservationRepository;
import com.muhikira.hotelReservation.requestBooking.ReservationRequest;
import com.muhikira.hotelReservation.service.HotelRoomService;
import com.muhikira.hotelReservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class HotelRoomController {
    private HotelRoomService hotelRoomService;
    private ReservationService reservationService;


    @Autowired
    public HotelRoomController(HotelRoomService hotelRoomService, ReservationService reservationService,
                               ReservationRepository reservationRepository) {
        this.hotelRoomService = hotelRoomService;
        this.reservationService = reservationService;

    }

    @PostMapping("/reservation")
    public Reservation createBooking(@RequestBody ReservationRequest reservationRequest) {
        return reservationService.save(reservationRequest);
    }

    @PostMapping("/create")
    public HotelRoom createRoom(@RequestBody HotelRoom hotelRoom) {
        return hotelRoomService.save(hotelRoom);
    }


}
