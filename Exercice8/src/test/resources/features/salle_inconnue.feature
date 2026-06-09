# language: fr
Fonctionnalité: Refus de réservation pour salle inconnue

  En tant que système de réservation
  Je veux refuser les demandes pour des salles inexistantes
  Afin de garantir l'intégrité du catalogue

  Scénario: Réservation refusée car la salle n'existe pas
    Étant donné qu'aucune salle n'existe pour le code "SAL-INCONNUE"
    Et aucune réservation existante pour la salle "SAL-INCONNUE"
    Quand l'utilisateur "alice@example.com" réserve la salle "SAL-INCONNUE" pour 3 participants du "2026-06-10T09:00" au "2026-06-10T10:00"
    Alors la réservation est refusée
    Et le motif de refus est "Salle inconnue : SAL-INCONNUE"
