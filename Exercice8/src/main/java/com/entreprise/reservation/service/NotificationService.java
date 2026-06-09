package com.entreprise.reservation.service;

import com.entreprise.reservation.model.ReservationConfirmation;

public interface NotificationService {

    void sendConfirmation(ReservationConfirmation confirmation);
}
