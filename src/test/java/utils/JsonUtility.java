package utils;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtility {

    private final Gson GSON = new Gson();

    public <T> T deserializeJson(String filePath, Class<T> tClass) {
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error reading the JSON file: " + filePath, e);
        }
    }

    public <T> T deserializeJsonFromString(String jsonString, Class<T> tClass) {
        return GSON.fromJson(jsonString, tClass);
    }

    public <T> void serializeJson(String filePath, T object) {
        try (FileWriter writer = new FileWriter(filePath)) {
            GSON.toJson(object, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to the JSON file: " + filePath, e);
        }
    }
}
