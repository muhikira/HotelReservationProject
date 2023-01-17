package com.muhikira.hotelReservation.repository;

import com.muhikira.hotelReservation.entity.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, Integer> {

}
