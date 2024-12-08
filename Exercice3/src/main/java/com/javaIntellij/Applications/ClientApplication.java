package com.javaIntellij.Applications;

import com.javaIntellij.Models.Client;
import com.javaIntellij.Services.IMetier;
import com.javaIntellij.Services.Impl.MetierClientImpl;

import java.util.Scanner;

public class ClientApplication {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int choix = 0;
            while (choix != 6){
                System.out.println("1-AFFICHER LA LISTE DES CLIENTS");
                System.out.println("2-RECHERCHER CLIENT (NOM)");
                System.out.println("3-AJOUTER CLIENT");
                System.out.println("4-SUPPRIMER CLIENT (NOM)");
                System.out.println("5-SAUVEGARDER CLIENT");
                System.out.println("6-QUITTER");
                System.out.print("Veuillez saisir votre choix: ");

                choix = sc.nextInt();
                sc.nextLine();

                IMetier<Client> metier = new MetierClientImpl();
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
                        metier.findByNom(sc.nextLine());
                        break;
                    case 3:
                        Client client  = new Client();
                        System.out.println("NOM : ");
                        client.setNom(sc.nextLine());
                        System.out.println("PRENOM : ");
                        client.setPrenom(sc.nextLine());
                        System.out.println("ADRESSE : ");
                        client.setAdresse(sc.nextLine());
                        System.out.println("TEL : ");
                        client.setTel(sc.nextLine());
                        System.out.println("EMAIL");
                        client.setEmail(sc.nextLine());
                        metier.add(client);
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
            }
            sc.close();
        }

}

