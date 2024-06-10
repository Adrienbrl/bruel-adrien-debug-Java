package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;	

/**
 * Simple brute force implementatison
 *
 */

 // Déclaration de la classe publique `ReadSymptomDataFromFile` qui implémente l'interface `ISymptomReader`.
public class ReadSymptomDataFromFile implements ISymptomReader {

	// Je déclare une variable privée qui stock le chemin du fichier.
	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */

	// Le constructeur de la classe initialise la variable 'filepath' à l'aide du chemin donné.
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override

	// J'implémente la méthode 'GetSymptoms' de l'interface 'ISymptomsReader'.
	public List<String> GetSymptoms() {

		// J'initialise une liste qui stock les symptômes lus.
		ArrayList<String> result = new ArrayList<String>();
		
		// Je vérifie que le chemin du fichier ne soit pas nul.
		if (filepath != null) {

			// Création d'un 'BufferedReader' pour lire à partir du fichier spécifié.
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));

				// Lecture de la 1ère ligne du fichier.
				String line = reader.readLine();
				
				// Je lis chaque ligne jusqu'à la fin du fichier, j'ajoute la ligne lue à la liste des résultats et je lis la ligne suivante.
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

				// Je ferme le lecteur de fichier après lecture complète de ce dernier. 
				reader.close();

			// Enfin je gère les potentielles execptions liées à la lecture du fichier.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Je retourne finalement la liste des symptômes lus.
		return result;
	}

}
