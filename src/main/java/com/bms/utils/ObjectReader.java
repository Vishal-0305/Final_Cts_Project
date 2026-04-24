package com.bms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectReader {
    public static Properties prop;

    public static String getProperty(String key) {
        try {
            if (prop == null) {
                prop = new Properties();
                // Ensure the path matches your project structure (src/test/resources)
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                prop.load(fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not find or load config.properties file.");
        }
        return prop.getProperty(key);
    }
}