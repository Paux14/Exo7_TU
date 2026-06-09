# language: fr
Fonctionnalité: Réservation acceptée

  En tant qu'employé
  Je veux réserver une salle existante sur un créneau libre
  Afin d'organiser une réunion

  Scénario: Réservation acceptée pour une salle disponible
    Étant donné une salle "SAL-A" nommée "Salle Alpha" avec une capacité de 10 personnes
    Et aucune réservation existante pour la salle "SAL-A"
    Quand l'utilisateur "alice@example.com" réserve la salle "SAL-A" pour 5 participants du "2026-06-10T09:00" au "2026-06-10T10:00"
    Alors la réservation est acceptée
    Et la confirmation contient le code salle "SAL-A"
    Et la confirmation contient 5 participants
    Et la confirmation contient le message "Réservation confirmée pour alice@example.com dans la salle SAL-A"
