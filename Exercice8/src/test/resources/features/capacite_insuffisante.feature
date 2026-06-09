# language: fr
Fonctionnalité: Refus de réservation pour capacité insuffisante

  En tant que système de réservation
  Je veux refuser les demandes dépassant la capacité de la salle
  Afin de respecter les contraintes de sécurité

  Scénario: Réservation refusée car le nombre de participants dépasse la capacité
    Étant donné une salle "SAL-C" nommée "Salle Gamma" avec une capacité de 6 personnes
    Et aucune réservation existante pour la salle "SAL-C"
    Quand l'utilisateur "carol@example.com" réserve la salle "SAL-C" pour 7 participants du "2026-06-10T11:00" au "2026-06-10T12:00"
    Alors la réservation est refusée
    Et le motif de refus est "Capacité insuffisante pour la salle SAL-C (max 6 participants)"
