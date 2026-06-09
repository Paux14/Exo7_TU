package com.boutique.commande.model;

import java.util.Optional;

public class OrderResult {

    private final boolean accepted;
    private final Optional<OrderReceipt> receipt;
    private final String rejectionReason;

    private OrderResult(boolean accepted, Optional<OrderReceipt> receipt, String rejectionReason) {
        this.accepted = accepted;
        this.receipt = receipt;
        this.rejectionReason = rejectionReason;
    }

    public static OrderResult accepted(OrderReceipt receipt) {
        return new OrderResult(true, Optional.of(receipt), null);
    }

    public static OrderResult rejected(String reason) {
        return new OrderResult(false, Optional.empty(), reason);
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Optional<OrderReceipt> getReceipt() {
        return receipt;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }
}
