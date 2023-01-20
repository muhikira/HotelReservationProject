package com.muhikira.hotelReservation.service;

import com.muhikira.hotelReservation.entity.Reservation;
import com.muhikira.hotelReservation.repository.HotelRoomRepository;
import com.muhikira.hotelReservation.repository.ReservationRepository;
import com.muhikira.hotelReservation.requestBooking.ReservationRequest;
import org.hibernate.annotations.DialectOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
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

    LocalDate tomorrow = LocalDate.now().plusDays(1);


    @Override
    public Reservation save(ReservationRequest reservationRequest) throws IllegalAccessException {


        Reservation reservation = new Reservation();
        reservation.setFirstName(reservationRequest.getFirstName());
        reservation.setLastName(reservationRequest.getLastName());
        reservation.setEmail(reservationRequest.getEmail());
        reservation.setCheckinDate(reservationRequest.getCheckinDate());
        reservation.setCheckoutDate(reservationRequest.getCheckoutDate());
        reservation.setRoom(hotelRoomRepository.findAll().get(0).getRoomNumber());
        isReservationDetailsValid(reservation);
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(int ReservationId) {
        reservationRepository.deleteById(ReservationId);
    }

    private boolean isReservationDetailsValid(Reservation reservation) throws IllegalAccessException {
        boolean isValid = true;

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        if(reservation.getCheckinDate().equals(LocalDate.now())){
            throw new IllegalAccessException("booking date should not be the day, please try to book tomorrow!");
        }

        if (reservation.getCheckinDate().isAfter(tomorrow.plusDays(30))) {
            throw new IllegalArgumentException("Start date must be within 30 days");
        }

        if (reservation.getCheckoutDate().isAfter((reservation.getCheckinDate().plusDays(3)))) {
            throw new IllegalAccessException("Stay must not be longer than 3 days");

        }
        return isValid;
    }
}
