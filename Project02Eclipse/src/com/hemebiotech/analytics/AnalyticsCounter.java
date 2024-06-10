package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Déclaration de la classe publique 'AnalyticsCounter'.
public class AnalyticsCounter {

	// Déclaration de la méthode principale 'main'.
	public static void main(String[] args) {

		// J'initialise une 'Map' pour stocker les symptômes et leurs occurrences.
        Map<String, Integer> symptomCounts = new HashMap<>();

        // Création d'un `BufferedReader` pour lire à partir du fichier "symptoms.txt".
        try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {

			// Je déclare une variable afin de stocker chaque ligne lue.
            String line;

			// Création d'une boucle qui permet de lire chaque ligne jusqu'à la fin du fichier.
            while ((line = reader.readLine()) != null) {

				// Met à jour 'Map' pour compter les occurrences de chaque symptôme lu dans le fichier.
				// Je vérifie si le symptôme ('line') est déjà présent dans 'Map' si oui j'obtiens son nombre d'occurrences actuel sinon 0 est utilisé comme valeur par défaut.
				// J'incrémente ensuite le nombre d'occurences du symptôme de 1 et met à jour la 'Map' avec le nouveau nombre d'occurrences du symptôme.
				// En résumé cette ligne me permet de lire un symptôme et de mettre à jour son comtpe dans une 'Map' en ajoutant 1 à chaque nouvelle rencontre du symptôme.
                symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
            }

		// Enfin je gère les potentielles execptions liées à la lecture du fichier.
        } catch (IOException e) {
            e.printStackTrace();
        }

		// Je crée une instance de 'WriteSymptomDataToFile' afin d'écrire les résultats dans "result.out".
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

		// Ecriture des symptômes ainsi que de leurs occurrences dans le fichier "result.out".
        writer.writeSymptoms(symptomCounts);
    }
}
