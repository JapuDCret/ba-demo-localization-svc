package de.mkienitz.bachelorarbeit.localization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TranslationService {

    private static Logger log = LoggerFactory.getLogger(TranslationService.class.getName());

    private static final Map<String, Map<String, String>> TRANSLATIONS = new TreeMap<String, Map<String, String>>()
    {{
        put("de", new TreeMap<String, String>(){{
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

    public Map<String, Map<String, String>> getTranslations() {
        String isIllPod = System.getenv("IS_ILL_POD");

        log.info("getTranslations(): env.IS_ILL_POD = " + isIllPod);

        if("true".equalsIgnoreCase(isIllPod)) {
            return null;
        }

        return Collections.unmodifiableMap(TRANSLATIONS);
    }
}
