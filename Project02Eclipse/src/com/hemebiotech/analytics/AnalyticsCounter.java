package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {

    public static void main(String[] args) {
        Map<String, Integer> symptomCounts = new HashMap<>();

        // Lire les symptômes à partir du fichier et compter les occurrences
        try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Écrire les symptômes et leurs comptes dans le fichier result.out
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        writer.writeSymptoms(symptomCounts);
    }
}
