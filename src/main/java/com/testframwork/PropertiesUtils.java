package com.testframwork;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Properties;

public class PropertiesUtils {
    public static String getProperty(String file, String key) {
        Properties prop = new Properties();
        try {
            prop.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(file));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return prop.getProperty(key);
    }
}
