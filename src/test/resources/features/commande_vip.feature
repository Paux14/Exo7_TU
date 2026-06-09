# language: fr
Fonctionnalité: Commande acceptée pour un client VIP

  En tant que client VIP
  Je veux bénéficier d'une remise de 20 %
  Afin d'obtenir le meilleur tarif

  Scénario: Commande acceptée avec remise VIP
    Étant donné un produit "REF-003" nommé "Clavier mécanique" au prix de 100.0 euros avec un stock de 8
    Et un client avec l'email "vip@example.com" et le profil "VIP"
    Quand le client commande 1 unité du produit "REF-003"
    Alors la commande est acceptée
    Et le reçu contient la référence "REF-003"
    Et le reçu contient la quantité 1
    Et le reçu contient le montant total 80.0
    Et le reçu contient le message "Commande confirmée pour vip@example.com"
