# language: fr
Fonctionnalité: Refus de commande pour produit inconnu

  En tant que boutique en ligne
  Je veux refuser les commandes de produits inexistants
  Afin de garantir la fiabilité du catalogue

  Scénario: Commande refusée car le produit n'existe pas
    Étant donné qu'aucun produit n'existe pour la référence "REF-INCONNU"
    Et un client avec l'email "client@example.com" et le profil "STANDARD"
    Quand le client commande 1 unité du produit "REF-INCONNU"
    Alors la commande est refusée
    Et le motif de refus est "Produit inconnu : REF-INCONNU"
