package com.muhikira.hotelReservation.requestBooking;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ReservationRequest {
    private String firstName;
    private String lastName;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private String email;

    public ReservationRequest(String firstName, String lastName, LocalDate checkinDate, LocalDate checkoutDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.email = email;
    }

}
