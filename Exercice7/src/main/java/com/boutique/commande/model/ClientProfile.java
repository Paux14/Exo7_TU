package com.boutique.commande.model;

public enum ClientProfile {
    STANDARD(0.0),
    PREMIUM(0.10),
    VIP(0.20);

    private final double discountRate;

    ClientProfile(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
