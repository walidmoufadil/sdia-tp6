package com.javaIntellij.Services.Impl;

import com.javaIntellij.Models.Client;
import com.javaIntellij.Services.IMetier;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client> {
    private final List<Client> clients = new ArrayList<>();
    private final String clientsFile = "Exercice3/data/clients.txt";

    @Override
    public Client add(Client client) {
        clients.add(client);
        saveAll();
        return client;
    }

    @Override
    public List<Client> getAll() {
        clients.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(clientsFile))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] details = ligne.split(",");
                if (details.length == 5) {
                    String nom = details[0].trim();
                    String prenom = details[1].trim();
                    String adresse = details[2].trim();
                    String tel = details[3].trim();
                    String email = details[4].trim();
                    // Création d'un objet Produit
                    Client client = new Client(nom,prenom,adresse,tel,email);
                    clients.add(client);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format dans le fichier : " + e.getMessage());
        }

        return clients;
    }

    @Override
    public Client findByNom(String nom) {
        return clients.stream().filter(c -> c.getNom().equals(nom)).findFirst().orElse(null);
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(c -> c.getNom().equals(nom));
    }

    @Override
    public void saveAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(clientsFile))) {
            for (Client client : clients) {
                // Convertir chaque produit en une ligne formatée
                String ligne = String.format("%s,%s,%s,%s,%s",
                        client.getNom(),
                        client.getPrenom(),
                        client.getAdresse(),
                        client.getTel(),
                        client.getEmail());

                writer.write(ligne);
                writer.newLine(); // Passer à la ligne suivante
            }
            System.out.println("Tous les produits ont été enregistrés dans le fichier : " + clientsFile);
            writer.flush();
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement des produits : " + e.getMessage());
        }

    }
}
