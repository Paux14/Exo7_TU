# language: fr
Fonctionnalité: Commande acceptée pour un client PREMIUM

  En tant que client PREMIUM
  Je veux bénéficier d'une remise de 10 %
  Afin de payer moins cher ma commande

  Scénario: Commande acceptée avec remise PREMIUM
    Étant donné un produit "REF-002" nommé "Souris sans fil" au prix de 30.0 euros avec un stock de 5
    Et un client avec l'email "premium@example.com" et le profil "PREMIUM"
    Quand le client commande 2 unités du produit "REF-002"
    Alors la commande est acceptée
    Et le reçu contient la référence "REF-002"
    Et le reçu contient la quantité 2
    Et le reçu contient le montant total 54.0
    Et le reçu contient le message "Commande confirmée pour premium@example.com"
