package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * AnalyticsCounter class is responsible for reading symptoms from a source,
 * counting occurrences, sorting them, and writing the results to a destination.
 */
public class AnalyticsCounter {
    private ISymptomReader reader;
    private ISymptomWriter writer;

    /**
     * Constructor for AnalyticsCounter.
     *
     * @param reader an instance of ISymptomReader to read symptoms from a source
     * @param writer an instance of ISymptomWriter to write symptoms to a destination
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Retrieves a list of symptoms from the data source.
     *
     * @return a list of symptoms
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Counts the occurrences of each symptom.
     *
     * @param symptoms a list of symptoms
     * @return a map with symptoms as keys and their occurrences as values
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();
        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
        return symptomCounts;
    }

    /**
     * Sorts the symptoms by their names in alphabetical order.
     *
     * @param symptoms a map with symptoms and their occurrences
     * @return a sorted map with symptoms as keys and their occurrences as values
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    /**
     * Writes the sorted symptoms and their occurrences to the data destination.
     *
     * @param symptoms a map with symptoms as keys and their occurrences as values
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}

