package com.javaIntellij.Services.Impl;


import com.javaIntellij.Models.Produit;
import com.javaIntellij.Services.IMetier;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {

    private final List<Produit> produits = new ArrayList<>();
    private final String produitsFile = "Exercice3/data/produits.txt";

    @Override
    public Produit add(Produit produit) {
        produits.add(produit);
        saveAll();
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        produits.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(produitsFile))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] details = ligne.split(",");
                if (details.length == 6) {
                    String nom = details[0].trim();
                    String marque = details[1].trim();
                    String description = details[2].trim();
                    double prix = Double.parseDouble(details[3].trim());
                    int stock = Integer.parseInt(details[5].trim());

                    // Création d'un objet Produit
                    Produit produit = new Produit(nom, marque, prix, description, stock);
                    produits.add(produit);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format dans le fichier : " + e.getMessage());
        }

        return produits;
    }

    @Override
    public Produit findByNom(String nom) {
        return produits.stream().filter(p -> p.getNom().equals(nom)).findFirst().orElse(null);
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(p -> p.getNom().equals(nom));
    }

    @Override
    public void saveAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(produitsFile))) {
            for (Produit produit : produits) {
                // Convertir chaque produit en une ligne formatée
                String ligne = String.format("%s,%s,%s,%.2f,%d",
                        produit.getNom(),
                        produit.getMarque(),
                        produit.getDescription(),
                        produit.getPrix(),
                        produit.getNombreEnStock());

                writer.write(ligne);
                writer.newLine(); // Passer à la ligne suivante
            }
            System.out.println("Tous les produits ont été enregistrés dans le fichier : " + produitsFile);
            writer.flush();
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement des produits : " + e.getMessage());
        }

    }
}
