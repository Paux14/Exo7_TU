# language: fr
Fonctionnalité: Commande acceptée pour un client STANDARD

  En tant que client STANDARD
  Je veux passer une commande valide
  Afin d'obtenir un reçu sans remise

  Scénario: Commande acceptée sans remise
    Étant donné un produit "REF-001" nommé "Casque Bluetooth" au prix de 50.0 euros avec un stock de 10
    Et un client avec l'email "client@example.com" et le profil "STANDARD"
    Quand le client commande 2 unités du produit "REF-001"
    Alors la commande est acceptée
    Et le reçu contient la référence "REF-001"
    Et le reçu contient la quantité 2
    Et le reçu contient le montant total 100.0
    Et le reçu contient le message "Commande confirmée pour client@example.com"
