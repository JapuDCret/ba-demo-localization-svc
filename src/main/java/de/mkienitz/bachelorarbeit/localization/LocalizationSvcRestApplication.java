package de.mkienitz.bachelorarbeit.localization;

import de.mkienitz.bachelorarbeit.localization.application.TranslationResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/data")
public class LocalizationSvcRestApplication extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalizationSvcRestApplication.class.getName());

    public static final String ENVVAR_IS_ILL_POD = "IS_ILL_POD";

    public LocalizationSvcRestApplication() {
        LOGGER.info("env." + ENVVAR_IS_ILL_POD + " = " + System.getenv(ENVVAR_IS_ILL_POD));
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();

        s.add(TranslationResource.class);

        return s;
    }
}
