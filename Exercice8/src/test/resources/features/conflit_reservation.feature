# language: fr
Fonctionnalité: Refus de réservation en cas de conflit

  En tant que système de réservation
  Je veux refuser les créneaux qui chevauchent une réservation existante
  Afin d'éviter les doubles réservations

  Scénario: Réservation refusée car le créneau chevauche une réservation existante
    Étant donné une salle "SAL-E" nommée "Salle Epsilon" avec une capacité de 12 personnes
    Et une réservation existante pour la salle "SAL-E" de "2026-06-10T09:00" à "2026-06-10T11:00"
    Quand l'utilisateur "eve@example.com" réserve la salle "SAL-E" pour 6 participants du "2026-06-10T10:00" au "2026-06-10T12:00"
    Alors la réservation est refusée
    Et le motif de refus est "Conflit de réservation pour la salle SAL-E"
