package com.entreprise.reservation.repository;

import com.entreprise.reservation.model.Reservation;

import java.util.List;

public interface ReservationRepository {

    List<Reservation> findByRoomCode(String codeSalle);
}
