package com.wikiraceassistant.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Controller to start the application
 * @author Sebastian Greenholtz
 */
@ApplicationPath("/")
public class WikiRaceApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(WikiPage.class );
        return h;
    }
}
