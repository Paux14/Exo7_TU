# language: fr
Fonctionnalité: Refus de réservation pour période invalide

  En tant que système de réservation
  Je veux refuser les créneaux dont la date de fin n'est pas postérieure à la date de début
  Afin de garantir la cohérence des plannings

  Scénario: Réservation refusée car la date de fin est égale à la date de début
    Étant donné une salle "SAL-D" nommée "Salle Delta" avec une capacité de 10 personnes
    Et aucune réservation existante pour la salle "SAL-D"
    Quand l'utilisateur "dave@example.com" réserve la salle "SAL-D" pour 4 participants du "2026-06-10T09:00" au "2026-06-10T09:00"
    Alors la réservation est refusée
    Et le motif de refus est "Période invalide : la date de fin doit être après la date de début"

  Scénario: Réservation refusée car la date de fin est avant la date de début
    Étant donné une salle "SAL-D" nommée "Salle Delta" avec une capacité de 10 personnes
    Et aucune réservation existante pour la salle "SAL-D"
    Quand l'utilisateur "dave@example.com" réserve la salle "SAL-D" pour 4 participants du "2026-06-10T10:00" au "2026-06-10T09:00"
    Alors la réservation est refusée
    Et le motif de refus est "Période invalide : la date de fin doit être après la date de début"
