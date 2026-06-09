package com.boutique.commande.model;

public class Product {

    private final String reference;
    private final String name;
    private final double unitPrice;
    private final int availableStock;

    public Product(String reference, String name, double unitPrice, int availableStock) {
        this.reference = reference;
        this.name = name;
        this.unitPrice = unitPrice;
        this.availableStock = availableStock;
    }

    public String getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getAvailableStock() {
        return availableStock;
    }
}
