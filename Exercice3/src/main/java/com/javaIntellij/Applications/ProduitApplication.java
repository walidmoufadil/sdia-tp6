package com.javaIntellij.Applications;

import com.javaIntellij.Models.Produit;
import com.javaIntellij.Services.IMetier;
import com.javaIntellij.Services.Impl.MetierProduitImpl;

import java.util.Scanner;

public class ProduitApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        while (choix != 6){
            System.out.println("1-AFFICHER LA LISTE DES PRODUITS");
            System.out.println("2-RECHERCHER PRODUIT (NOM)");
            System.out.println("3-AJOUTER PRODUIT");
            System.out.println("4-SUPPRIMER PRODUIT (NOM)");
            System.out.println("5-SAUVEGARDER PRODUIT");
            System.out.println("6-QUITTER");
            System.out.print("Veuillez saisir votre choix: ");

            choix = sc.nextInt();
            sc.nextLine();
            IMetier<Produit> metier = new MetierProduitImpl();
            switch (choix){
                case 1:
                    try {
                        metier.getAll().forEach(System.out::println);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.print("Veuillez saisir le nom : ");
                    System.out.println(metier.findByNom(sc.nextLine()));
                    break;
                case 3:
                    Produit produit = new Produit();
                    System.out.print("NOM : ");
                    produit.setNom(sc.nextLine());
                    System.out.print("MARQUE : ");
                    produit.setMarque(sc.nextLine());
                    System.out.print("DESCRIPTION : ");
                    produit.setDescription(sc.nextLine());
                    System.out.print("PRIX : ");
                    produit.setPrix(sc.nextDouble());
                    System.out.print("STOCK : ");
                    produit.setNombreEnStock(sc.nextInt());
                    metier.add(produit);
                    break;
                case 4:
                    System.out.print("Veuillez saisir le nom : ");
                    metier.delete(sc.nextLine());
                    break;
                case 5:
                    metier.saveAll();
                    break;
                case 6:
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("choix invalide");

            }
            sc.nextLine();
        }
        sc.close();
    }
}
