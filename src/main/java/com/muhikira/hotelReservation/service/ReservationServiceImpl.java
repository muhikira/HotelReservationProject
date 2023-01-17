package com.muhikira.hotelReservation.service;

import com.muhikira.hotelReservation.entity.Reservation;
import com.muhikira.hotelReservation.repository.HotelRoomRepository;
import com.muhikira.hotelReservation.repository.ReservationRepository;
import com.muhikira.hotelReservation.requestBooking.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private final HotelRoomRepository hotelRoomRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  HotelRoomRepository hotelRoomRepository) {
        this.reservationRepository = reservationRepository;
        this.hotelRoomRepository = hotelRoomRepository;
    }
    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(int theId) throws Exception {
        Optional<Reservation> foundReservation = reservationRepository.findById(theId);
        if (foundReservation.isEmpty()) {
            throw new Exception("Reservation not found");
        }
        return foundReservation.get();
    }
    @Override
    public Reservation save(ReservationRequest reservationRequest) {
        Reservation reservation = new Reservation();
        reservation.setFirstName(reservationRequest.getFirstName());
        reservation.setLastName(reservationRequest.getLastName());
        reservation.setEmail(reservationRequest.getEmail());
        reservation.setCheckinDate(reservationRequest.getCheckinDate());
        reservation.setCheckoutDate(reservationRequest.getCheckoutDate());
        reservation.setRoom(hotelRoomRepository.findAll().get(0).getRoomNumber());
       return reservationRepository.save(reservation);

    }
    @Override
    public void deleteById(int ReservationId) {
        reservationRepository.deleteById(ReservationId);
    }
}
