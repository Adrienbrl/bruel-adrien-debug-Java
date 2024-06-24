package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * The Main class is the entry point for the application.
 * It initializes the necessary components and orchestrates the process
 * of reading symptoms, counting occurrences, sorting the results, and writing the output.
 */
public class Main {

    /**
     * The main method is the entry point of the application.
     * It initializes the ISymptomReader and ISymptomWriter implementations,
     * creates an instance of AnalyticsCounter, and executes the steps to process the symptoms data.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("results.out");

        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> symptomCounts = counter.countSymptoms(symptoms); 
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts); 
        counter.writeSymptoms(sortedSymptoms); 
    }
}
