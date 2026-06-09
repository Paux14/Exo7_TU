# language: fr
Fonctionnalité: Notification envoyée en cas de succès

  En tant que système de réservation
  Je veux envoyer une confirmation par notification lorsque la réservation est acceptée
  Afin d'informer l'utilisateur

  Scénario: Notification envoyée après une réservation acceptée
    Étant donné une salle "SAL-G" nommée "Salle Eta" avec une capacité de 15 personnes
    Et aucune réservation existante pour la salle "SAL-G"
    Quand l'utilisateur "grace@example.com" réserve la salle "SAL-G" pour 3 participants du "2026-06-11T09:00" au "2026-06-11T10:00"
    Alors la réservation est acceptée
    Et une notification de confirmation est envoyée
