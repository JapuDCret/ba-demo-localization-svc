package de.mkienitz.bachelorarbeit.localization;

import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 */
@Path("/translations")
@Singleton
public class TranslationResource {

    private static Logger logger = Logger.getLogger(TranslationResource.class.getName());

    @Inject
    private TranslationService service;

    @GET
    @Operation(description = "Get translations")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getTranslations() {
        return Response.ok(service.getTranslations()).build();
    }
}
