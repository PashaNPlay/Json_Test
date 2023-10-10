package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;

public class JsonHouseSerializer {
    private final File JSON_FILE;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonHouseSerializer(Path jsonFilePath) {
        this.JSON_FILE = jsonFilePath.toFile();

    }

    public void serialize(House house) {
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            String jsonString = objectMapper.writeValueAsString(house);
            writer.write(jsonString);
        } catch (IOException e) {
            System.err.println("Input-Output Exception:\n" + e);
        }
    }

    public House deserialize() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(JSON_FILE))) {
            String inputJsonString = bufferedReader.readLine();
            return objectMapper.readValue(inputJsonString, House.class);
        } catch (IOException e) {
            System.err.println("Input-Output Exception:\n" + e);
            return null;
        }
    }
}
