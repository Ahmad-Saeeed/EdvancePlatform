package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    // Load default config.properties automatically
    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Could not find config.properties file in resources!");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties file!", e);
        }
    }

    // Read key from default config.properties
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Load any additional properties file (teacher, student, company…)
    public static String getProperty(String fileName, String key) {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new RuntimeException("Could not find file: " + fileName + " in resources!");
            }
            Properties tempProp = new Properties();
            tempProp.load(input);
            return tempProp.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Could not load file: " + fileName, e);
        }
    }
}
