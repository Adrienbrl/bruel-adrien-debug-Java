package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a destination.
 */
public interface ISymptomWriter {
    
    /**
     * Writes symptoms and their occurrences to a destination.
     *
     * @param symptoms a map with symptoms as keys and their occurrences as values
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}

