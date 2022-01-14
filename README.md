# Prix-d-un-Produit
l'application Android dans un nouveau projet du nom Prix d’un Produit

- L’application doit permettre à l'utilisateur d'introduire le prix d’un produit, le nombre du produit commandé et le taux de TVA (la Taxe sur la Valeur Ajoutée), de calculer et d'afficher le prix hors taxe et le prix toute taxe comprise du produit commandé.
- Pour le nombre de produit commandé et le TVA, il faut affecter des valeurs par défaut respectivement de 1 et de 18% (0,18) qui doivent être affichées dans les champs Nombre de produit commandé et TVA correspondants. Ces valeurs seront utilisées par défaut dans le cas où l'utilisateur ne les a pas introduits.
- Si prix, nombreProduit et tva désignent respectivement le prix du produit, le nombre du produit commandé et le taux de TVA (qui doit être compris entre 0 et 1), alors le prix hors taxe et toute taxe comprise du produit commandé pourront être calculés par les équations :
  - prixHT = prix × nombreProduit et prixTTC = prix × nombreProduit (1 + tva)
