package com.hemebiotech.analytics;

// Importation de l'interface Map 
import java.util.Map;

// Déclaration de l'interface publique 'ISymptomWriter'
public interface ISymptomWriter {

    // Déclaration de la méthode 'writeSymptoms' qui prend un argument de type 'Map<String, Integer>'
    void writeSymptoms(Map<String, Integer> symptoms);
}

// J'ai utilisé 'Map' pour l'association clé-valeur. 

// Dans ce cas, chaque symptôme (clé de type 'String') est associé à un nombre d'occurrences (valeur de type 'Integer'). 

// C'est très utile pour rechercher et manipuler des symptômes et leurs comptes. 

// 'Map' facilite la lecture du code et aide à mieux gérer les paires clé-valeur que d'autres structures comme les listes par exemple.
