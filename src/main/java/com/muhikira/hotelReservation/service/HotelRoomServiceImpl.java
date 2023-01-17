package com.muhikira.hotelReservation.service;

import com.muhikira.hotelReservation.entity.HotelRoom;
import com.muhikira.hotelReservation.repository.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HotelRoomServiceImpl implements HotelRoomService {
    private HotelRoomRepository hotelRoomRepository;
    @Autowired
    public void SetHotelRoomRepository (HotelRoomRepository hotelRoomRepository){
        this.hotelRoomRepository = hotelRoomRepository;
    }
    @Override
    public List<HotelRoom> getAll() {
        return hotelRoomRepository.findAll();
    }
    @Override
    public HotelRoom findById(int hotelRoomId) {
        return null;
    }
      @Override
    public HotelRoom save(HotelRoom hotelRoom) {
        return hotelRoomRepository.save(hotelRoom);

    }
    @Override
    public void deleteById(int id) {

    }
}
