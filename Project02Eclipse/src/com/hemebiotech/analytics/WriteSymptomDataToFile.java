package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


/**
 * WriteSymptomDataToFile is an implementation of the ISymptomWriter interface.
 * This class is responsible for writing symptoms and their occurrences to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
 
    private String filepath;

    /**
     * Constructor for WriteSymptomDataToFile.
     *
     * @param filepath a full or partial path to file where symptom data will be written
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writes symptoms and their occurrences to a file specified by the filepath.
     *
     * @param symptoms a map with symptoms as keys and their occurrences as values
     */
    @Override

    public void writeSymptoms(Map<String, Integer> symptoms) {

        if (filepath != null && symptoms != null) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {

                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

                    writer.write(entry.getKey() + " : " + entry.getValue());

                    writer.newLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

