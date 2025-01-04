package utils;

import models.*;
import lombok.experimental.UtilityClass;

import java.io.File;

import models.requests.UserDataPayload;
import org.json.JSONObject;
import java.nio.file.Files;

@UtilityClass
public class SettingsTestData {
    public final String RESOURCES_PATH = "src/test/resources/";
    public final String TEST_DATA_PATH = RESOURCES_PATH + "testdata/";
    private final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    private final String USER_FILE_PATH = TEST_DATA_PATH + "credential.json";
    private final File ENVIRONMENT_CONFIG = new File(RESOURCES_PATH + "env.json");


    public EnvData getEnvData() {
        String envConfigPath = "%s%s.json".formatted(ENVIRONMENT_PATH, getCurrentEnvironment());
        return JsonUtility.deserializeJson(envConfigPath, EnvData.class);
    }

    public UserDataPayload getUserData() {
        return JsonUtility.deserializeJson(USER_FILE_PATH, UserDataPayload.class);
    }

    private String getCurrentEnvironment() {
        try {
            JSONObject jsonObject = new JSONObject(Files.readString(ENVIRONMENT_CONFIG.toPath()));
            return jsonObject.getString("env");
        } catch (Exception e) {
            throw new RuntimeException("Error reading environment config", e);
        }
    }
}
