package com.wikiraceassistant.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Parses entity into JSON
 * @author Sebastian Greenholtz
 */
public class JSONParser {

    private static final Logger logger = Logger.getLogger(JSONParser.class);

    public static <T> String parse(T entity) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(entity);
        } catch (IOException e) {
            logger.error(e);
        }
        return json;
    }
}
