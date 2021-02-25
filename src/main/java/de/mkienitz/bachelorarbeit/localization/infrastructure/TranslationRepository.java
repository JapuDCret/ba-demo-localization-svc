package de.mkienitz.bachelorarbeit.localization.infrastructure;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class TranslationRepository {

    private static final Map<String, Map<String, String>> TRANSLATIONS = new LinkedHashMap<String, Map<String, String>>()
    {{
        put("de", new LinkedHashMap<String, String>(){{
            put("item.cantaloupe", "Honigmelone");
            put("item.coconut", "Kokosnuss");
            put("item.grapes", "Trauben");
            put("item.peach", "Pfirsich");
            put("item.pear", "Birne");
            put("item.pineapple", "Ananas");
            put("item.pomegranate", "Granatapfel");
            put("item.watermelon", "Wassermelone");
        }});
    }};

    @Traced(operationName = "TranslationRepository.read")
    public Map<String, Map<String, String>> read() {
        return Collections.unmodifiableMap(TRANSLATIONS);
    }
}
