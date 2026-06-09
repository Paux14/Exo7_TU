package com.entreprise.reservation.repository;

import com.entreprise.reservation.model.Room;

import java.util.Optional;

public interface RoomRepository {

    Optional<Room> findByCode(String code);
}
