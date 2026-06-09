# language: fr
Fonctionnalité: Refus de commande pour stock insuffisant

  En tant que boutique en ligne
  Je veux refuser les commandes dépassant le stock disponible
  Afin de ne pas vendre de produits indisponibles

  Scénario: Commande refusée car le stock est insuffisant
    Étant donné un produit "REF-004" nommé "Webcam HD" au prix de 45.0 euros avec un stock de 2
    Et un client avec l'email "client@example.com" et le profil "STANDARD"
    Quand le client commande 5 unités du produit "REF-004"
    Alors la commande est refusée
    Et le motif de refus est "Stock insuffisant pour le produit REF-004"
