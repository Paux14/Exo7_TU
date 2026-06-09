package com.entreprise.reservation.bdd;

import com.entreprise.reservation.model.Reservation;
import com.entreprise.reservation.model.Room;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Alors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReservationStepDefinitions {

    private final ReservationTestContext context;

    public ReservationStepDefinitions(ReservationTestContext context) {
        this.context = context;
    }

    @Etantdonné("une salle {string} nommée {string} avec une capacité de {int} personnes")
    public void uneSalleExiste(String code, String nom, int capacite) {
        Room room = new Room(code, nom, capacite);
        when(context.getRoomRepository().findByCode(eq(code)))
                .thenReturn(Optional.of(room));
    }

    @Etantdonné("aucune salle n'existe pour le code {string}")
    public void aucuneSallePourCode(String code) {
        when(context.getRoomRepository().findByCode(eq(code)))
                .thenReturn(Optional.empty());
    }

    @Etantdonné("aucune réservation existante pour la salle {string}")
    public void aucuneReservationExistante(String codeSalle) {
        when(context.getReservationRepository().findByRoomCode(eq(codeSalle)))
                .thenReturn(Collections.emptyList());
    }

    @Etantdonné("une réservation existante pour la salle {string} de {string} à {string}")
    public void uneReservationExistante(String codeSalle, String debut, String fin) {
        Reservation existing = new Reservation(
                "existant@example.com",
                codeSalle,
                5,
                LocalDateTime.parse(debut),
                LocalDateTime.parse(fin)
        );
        when(context.getReservationRepository().findByRoomCode(eq(codeSalle)))
                .thenReturn(List.of(existing));
    }

    @Etantdonné("les réservations existantes pour la salle {string} :")
    public void lesReservationsExistantes(String codeSalle, io.cucumber.datatable.DataTable dataTable) {
        List<Reservation> reservations = new ArrayList<>();
        for (var row : dataTable.asMaps()) {
            reservations.add(new Reservation(
                    row.get("email"),
                    codeSalle,
                    Integer.parseInt(row.get("participants")),
                    LocalDateTime.parse(row.get("debut")),
                    LocalDateTime.parse(row.get("fin"))
            ));
        }
        when(context.getReservationRepository().findByRoomCode(eq(codeSalle)))
                .thenReturn(reservations);
    }

    @Quand("l'utilisateur {string} réserve la salle {string} pour {int} participants du {string} au {string}")
    public void lUtilisateurReserve(String email, String codeSalle, int participants,
                                    String debut, String fin) {
        Reservation reservation = new Reservation(
                email,
                codeSalle,
                participants,
                LocalDateTime.parse(debut),
                LocalDateTime.parse(fin)
        );
        context.setLastResult(context.getReservationService().reserve(reservation));
    }

    @Alors("la réservation est acceptée")
    public void laReservationEstAcceptee() {
        assertTrue(context.getLastResult().isAccepted());
    }

    @Alors("la réservation est refusée")
    public void laReservationEstRefusee() {
        assertFalse(context.getLastResult().isAccepted());
    }

    @Et("le motif de refus est {string}")
    public void leMotifDeRefusEst(String motif) {
        assertEquals(motif, context.getLastResult().getRejectionReason());
    }

    @Et("la confirmation contient le code salle {string}")
    public void laConfirmationContientCodeSalle(String codeSalle) {
        assertEquals(codeSalle, context.getLastResult().getConfirmation().orElseThrow().getCodeSalle());
    }

    @Et("la confirmation contient {int} participants")
    public void laConfirmationContientParticipants(int participants) {
        assertEquals(participants, context.getLastResult().getConfirmation().orElseThrow().getNombreParticipants());
    }

    @Et("la confirmation contient le message {string}")
    public void laConfirmationContientMessage(String message) {
        assertEquals(message, context.getLastResult().getConfirmation().orElseThrow().getMessage());
    }

    @Et("une notification de confirmation est envoyée")
    public void uneNotificationEstEnvoyee() {
        verify(context.getNotificationService()).sendConfirmation(any());
    }

    @Et("aucune notification n'est envoyée")
    public void aucuneNotificationNestEnvoyee() {
        verify(context.getNotificationService(), never()).sendConfirmation(any());
    }
}
