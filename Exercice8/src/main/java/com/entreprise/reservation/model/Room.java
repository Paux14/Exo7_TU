package com.entreprise.reservation.model;

public class Room {

    private final String code;
    private final String nom;
    private final int capaciteMaximale;

    public Room(String code, String nom, int capaciteMaximale) {
        this.code = code;
        this.nom = nom;
        this.capaciteMaximale = capaciteMaximale;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }
}
