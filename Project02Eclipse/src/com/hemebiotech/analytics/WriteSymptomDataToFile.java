package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

// Déclaration de la classe publique `WriteSymptomDataToFile` qui implémente l'interface `ISymptomWriter`.
public class WriteSymptomDataToFile implements ISymptomWriter {

    // Je déclare une variable privée qui stock le chemin du fichier.
    private String filepath;

    // Le constructeur de la classe initialise la variable 'filepath' à l'aide du chemin donné.
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override

    // J'implémente la méthode 'writeSymptoms' de l'interface 'ISymptomsWriter'.
    public void writeSymptoms(Map<String, Integer> symptoms) {

        // Je vérifie que le chemin du fichier et que la 'Map' des symptômes ne sont pas nuls.
        if (filepath != null && symptoms != null) {

            // Création d'un 'BufferedReader' pour lire à partir du fichier spécifié.
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {

                // Je parcours chaque entrée dans la 'Map' des symptômes.
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

                    // Ecriture de la clé (symptôme) et de sa valeur (nombre d'occurrences) dans le fichier.
                    writer.write(entry.getKey() + " : " + entry.getValue());

                    // Ajout d'une nouvelle ligne après chaque entrée.
                    writer.newLine();
                }

            // Enfin je gère les potentielles execptions liées à l'écriture dans le fichier.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

