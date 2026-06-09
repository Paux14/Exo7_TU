# language: fr
Fonctionnalité: Réservation acceptée à capacité maximale

  En tant qu'employé
  Je veux réserver une salle avec le nombre exact de participants autorisés
  Afin d'utiliser toute la capacité disponible

  Scénario: Réservation acceptée avec le nombre maximal de participants
    Étant donné une salle "SAL-B" nommée "Salle Beta" avec une capacité de 8 personnes
    Et aucune réservation existante pour la salle "SAL-B"
    Quand l'utilisateur "bob@example.com" réserve la salle "SAL-B" pour 8 participants du "2026-06-10T14:00" au "2026-06-10T15:00"
    Alors la réservation est acceptée
    Et la confirmation contient 8 participants
