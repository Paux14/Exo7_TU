# language: fr
Fonctionnalité: Notification non envoyée en cas d'échec

  En tant que système de réservation
  Je ne dois pas envoyer de notification lorsque la réservation est refusée
  Afin d'éviter des confirmations erronées

  Scénario: Aucune notification envoyée pour une salle inconnue
    Étant donné qu'aucune salle n'existe pour le code "SAL-INCONNUE"
    Et aucune réservation existante pour la salle "SAL-INCONNUE"
    Quand l'utilisateur "henry@example.com" réserve la salle "SAL-INCONNUE" pour 2 participants du "2026-06-11T09:00" au "2026-06-11T10:00"
    Alors la réservation est refusée
    Et aucune notification n'est envoyée

  Scénario: Aucune notification envoyée en cas de conflit de réservation
    Étant donné une salle "SAL-H" nommée "Salle Theta" avec une capacité de 10 personnes
    Et une réservation existante pour la salle "SAL-H" de "2026-06-11T14:00" à "2026-06-11T15:00"
    Quand l'utilisateur "henry@example.com" réserve la salle "SAL-H" pour 4 participants du "2026-06-11T14:30" au "2026-06-11T15:30"
    Alors la réservation est refusée
    Et aucune notification n'est envoyée
