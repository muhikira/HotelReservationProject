package com.muhikira.hotelReservation.service;

import com.muhikira.hotelReservation.entity.HotelRoom;

import java.util.List;

public interface HotelRoomService {
    public List<HotelRoom> getAll();
    HotelRoom findById(int hotelRoomId);

    public HotelRoom save(HotelRoom hotelRoom);
    public void deleteById(int id);
}
