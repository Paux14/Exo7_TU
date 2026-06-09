package com.entreprise.reservation.service;

import com.entreprise.reservation.model.Reservation;
import com.entreprise.reservation.model.ReservationConfirmation;
import com.entreprise.reservation.model.ReservationResult;
import com.entreprise.reservation.model.Room;
import com.entreprise.reservation.repository.ReservationRepository;
import com.entreprise.reservation.repository.RoomRepository;

import java.time.LocalDateTime;

public class ReservationService {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final NotificationService notificationService;

    public ReservationService(RoomRepository roomRepository,
                              ReservationRepository reservationRepository,
                              NotificationService notificationService) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.notificationService = notificationService;
    }

    public ReservationResult reserve(Reservation reservation) {
        Room room = roomRepository.findByCode(reservation.getCodeSalle()).orElse(null);

        if (room == null) {
            return ReservationResult.rejected("Salle inconnue : " + reservation.getCodeSalle());
        }

        if (reservation.getNombreParticipants() > room.getCapaciteMaximale()) {
            return ReservationResult.rejected(
                    "Capacité insuffisante pour la salle " + room.getCode()
                            + " (max " + room.getCapaciteMaximale() + " participants)");
        }

        if (!reservation.getDateFin().isAfter(reservation.getDateDebut())) {
            return ReservationResult.rejected("Période invalide : la date de fin doit être après la date de début");
        }

        boolean conflict = reservationRepository.findByRoomCode(reservation.getCodeSalle()).stream()
                .anyMatch(existing -> overlaps(
                        reservation.getDateDebut(),
                        reservation.getDateFin(),
                        existing.getDateDebut(),
                        existing.getDateFin()
                ));

        if (conflict) {
            return ReservationResult.rejected(
                    "Conflit de réservation pour la salle " + reservation.getCodeSalle());
        }

        ReservationConfirmation confirmation = new ReservationConfirmation(
                reservation.getEmailUtilisateur(),
                reservation.getCodeSalle(),
                reservation.getNombreParticipants(),
                reservation.getDateDebut(),
                reservation.getDateFin(),
                "Réservation confirmée pour " + reservation.getEmailUtilisateur()
                        + " dans la salle " + reservation.getCodeSalle()
        );

        notificationService.sendConfirmation(confirmation);
        return ReservationResult.accepted(confirmation);
    }

    private boolean overlaps(LocalDateTime debut1, LocalDateTime fin1,
                             LocalDateTime debut2, LocalDateTime fin2) {
        return debut1.isBefore(fin2) && debut2.isBefore(fin1);
    }
}
