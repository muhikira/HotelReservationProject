package com.muhikira.hotelReservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class HotelRoom {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)


    private int id;
    private String roomNumber;
    private boolean roomAvailability;

    public HotelRoom(String roomNumber, boolean roomAvailability) {
        this.roomNumber = roomNumber;
        this.roomAvailability = roomAvailability;
    }
}
