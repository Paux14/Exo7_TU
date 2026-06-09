package com.boutique.commande.model;

public class Order {

    private final String clientEmail;
    private final String productReference;
    private final int quantity;
    private final ClientProfile clientProfile;

    public Order(String clientEmail, String productReference, int quantity, ClientProfile clientProfile) {
        this.clientEmail = clientEmail;
        this.productReference = productReference;
        this.quantity = quantity;
        this.clientProfile = clientProfile;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getProductReference() {
        return productReference;
    }

    public int getQuantity() {
        return quantity;
    }

    public ClientProfile getClientProfile() {
        return clientProfile;
    }
}
