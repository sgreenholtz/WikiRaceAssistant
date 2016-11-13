package com.wikiraceassistant.utility;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Loads the properties file from the resources folder
 * @author Sebastian Greenholtz
 */
public class PropertiesLoader {

    public static final Logger logger = Logger.getLogger(PropertiesLoader.class);

    public static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream in = PropertiesLoader.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(in);
        } catch (IOException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }
        return properties;
    }
}
