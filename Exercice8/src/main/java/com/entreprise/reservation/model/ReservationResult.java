package com.entreprise.reservation.model;

import java.util.Optional;

public class ReservationResult {

    private final boolean accepted;
    private final Optional<ReservationConfirmation> confirmation;
    private final String rejectionReason;

    private ReservationResult(boolean accepted, Optional<ReservationConfirmation> confirmation,
                              String rejectionReason) {
        this.accepted = accepted;
        this.confirmation = confirmation;
        this.rejectionReason = rejectionReason;
    }

    public static ReservationResult accepted(ReservationConfirmation confirmation) {
        return new ReservationResult(true, Optional.of(confirmation), null);
    }

    public static ReservationResult rejected(String reason) {
        return new ReservationResult(false, Optional.empty(), reason);
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Optional<ReservationConfirmation> getConfirmation() {
        return confirmation;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }
}
