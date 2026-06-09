# language: fr
Fonctionnalité: Réservation acceptée après un créneau existant

  En tant qu'employé
  Je veux réserver une salle juste après une réunion existante
  Afin d'enchaîner les réunions sans conflit

  Scénario: Réservation acceptée lorsque le créneau commence après une réservation existante
    Étant donné une salle "SAL-F" nommée "Salle Zeta" avec une capacité de 10 personnes
    Et une réservation existante pour la salle "SAL-F" de "2026-06-10T09:00" à "2026-06-10T10:00"
    Quand l'utilisateur "frank@example.com" réserve la salle "SAL-F" pour 5 participants du "2026-06-10T10:00" au "2026-06-10T11:00"
    Alors la réservation est acceptée
    Et la confirmation contient le code salle "SAL-F"
