package com.boutique.commande.bdd;

import com.boutique.commande.model.ClientProfile;
import com.boutique.commande.model.Order;
import com.boutique.commande.model.Product;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Alors;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class OrderStepDefinitions {

    private final OrderTestContext context;

    public OrderStepDefinitions(OrderTestContext context) {
        this.context = context;
    }

    @Etantdonné("un produit {string} nommé {string} au prix de {double} euros avec un stock de {int}")
    public void unProduitExiste(String reference, String nom, double prix, int stock) {
        Product product = new Product(reference, nom, prix, stock);
        when(context.getProductRepository().findByReference(eq(reference)))
                .thenReturn(Optional.of(product));
    }

    @Etantdonné("aucun produit n'existe pour la référence {string}")
    public void aucunProduitPourReference(String reference) {
        when(context.getProductRepository().findByReference(eq(reference)))
                .thenReturn(Optional.empty());
    }

    @Et("un client avec l'email {string} et le profil {string}")
    public void unClientAvecProfil(String email, String profil) {
        context.setClientEmail(email);
        context.setClientProfile(ClientProfile.valueOf(profil));
    }

    @Quand("le client commande {int} unité du produit {string}")
    @Quand("le client commande {int} unités du produit {string}")
    public void leClientCommande(int quantite, String reference) {
        Order order = new Order(
                context.getClientEmail(),
                reference,
                quantite,
                context.getClientProfile()
        );
        context.setLastResult(context.getOrderService().processOrder(order));
    }

    @Alors("la commande est acceptée")
    public void laCommandeEstAcceptee() {
        assertTrue(context.getLastResult().isAccepted());
    }

    @Alors("la commande est refusée")
    public void laCommandeEstRefusee() {
        assertFalse(context.getLastResult().isAccepted());
    }

    @Et("le reçu contient la référence {string}")
    public void leRecuContientReference(String reference) {
        assertEquals(reference, context.getLastResult().getReceipt().orElseThrow().getProductReference());
    }

    @Et("le reçu contient la quantité {int}")
    public void leRecuContientQuantite(int quantite) {
        assertEquals(quantite, context.getLastResult().getReceipt().orElseThrow().getQuantity());
    }

    @Et("le reçu contient le montant total {double}")
    public void leRecuContientMontantTotal(double montant) {
        assertEquals(montant, context.getLastResult().getReceipt().orElseThrow().getTotalAmount(), 0.001);
    }

    @Et("le reçu contient le message {string}")
    public void leRecuContientMessage(String message) {
        assertEquals(message, context.getLastResult().getReceipt().orElseThrow().getConfirmationMessage());
    }

    @Et("le motif de refus est {string}")
    public void leMotifDeRefusEst(String motif) {
        assertEquals(motif, context.getLastResult().getRejectionReason());
    }
}
