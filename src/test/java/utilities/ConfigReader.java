package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

   static Properties properties;
    static FileInputStream inputStream;

    static {
        properties = new Properties();
        try {
            inputStream = new FileInputStream("Config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperties(String key){
        return properties.getProperty(key);
    }
}
