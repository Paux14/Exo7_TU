package com.entreprise.reservation.bdd;

import com.entreprise.reservation.model.ReservationResult;
import com.entreprise.reservation.repository.ReservationRepository;
import com.entreprise.reservation.repository.RoomRepository;
import com.entreprise.reservation.service.NotificationService;
import com.entreprise.reservation.service.ReservationService;
import org.mockito.Mockito;

public class ReservationTestContext {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final NotificationService notificationService;
    private final ReservationService reservationService;
    private ReservationResult lastResult;

    public ReservationTestContext() {
        this.roomRepository = Mockito.mock(RoomRepository.class);
        this.reservationRepository = Mockito.mock(ReservationRepository.class);
        this.notificationService = Mockito.mock(NotificationService.class);
        this.reservationService = new ReservationService(
                roomRepository,
                reservationRepository,
                notificationService
        );
    }

    public RoomRepository getRoomRepository() {
        return roomRepository;
    }

    public ReservationRepository getReservationRepository() {
        return reservationRepository;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public ReservationResult getLastResult() {
        return lastResult;
    }

    public void setLastResult(ReservationResult lastResult) {
        this.lastResult = lastResult;
    }
}
