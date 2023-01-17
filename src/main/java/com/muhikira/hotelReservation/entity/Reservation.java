package com.muhikira.hotelReservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name="Reservation")
@Data
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private String email;
    private String room;

    public Reservation(String firstName, String lastName, LocalDate checkinDate, LocalDate checkoutDate, String email, String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.email = email;
        this.room = room;
    }
}
