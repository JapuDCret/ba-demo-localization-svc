package de.mkienitz.bachelorarbeit.localization.application;

import de.mkienitz.bachelorarbeit.localization.LocalizationSvcRestApplication;
import de.mkienitz.bachelorarbeit.localization.infrastructure.TranslationRepository;
import io.opentracing.Tracer;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;

@ApplicationScoped
public class TranslationApplicationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TranslationApplicationService.class.getName());

    @Inject
    private Tracer tracer;

    @Inject
    private TranslationRepository repository;

    @Traced(operationName = "TranslationApplicationService.getTranslations")
    public Map<String, Map<String, String>> getTranslations() {
        String isIllPod = System.getenv(LocalizationSvcRestApplication.ENVVAR_IS_ILL_POD);

        LOGGER.info("getTranslations(): env.IS_ILL_POD = " + isIllPod);

        if("true".equalsIgnoreCase(isIllPod)) {
            LOGGER.info("getTranslations(): configuration is invalid, returning null");

            tracer.activeSpan()
                    .log("configuration is invalid")
                    .setTag("component", "configuration")
                    .setTag("error", true)
                    .finish();

            // simulate failed instantiation by returning null
            return null;
        }

        return repository.read();
    }
}
