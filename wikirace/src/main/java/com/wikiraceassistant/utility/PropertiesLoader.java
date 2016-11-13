package com.wikiraceassistant.utility;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads the properties file from the resources folder
 * @author Sebastian Greenholtz
 */
public class PropertiesLoader {

    public static final Logger logger = Logger.getLogger(PropertiesLoader.class);

    public static Properties getProperties() {
        Properties properties = null;
        try (InputStream in = PropertiesLoader.class.getResourceAsStream("application.properties")) {
            properties.load(in);
        } catch (IOException e) {
            logger.error(e);
        } catch (NullPointerException e) {
            logger.error("Properties file not found at given location: " + e);
        }
        return properties;
    }
}
