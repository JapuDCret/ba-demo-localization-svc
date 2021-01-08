package de.mkienitz.bachelorarbeit.localization;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("/translations")
@Singleton
public class TranslationResource {

    private static Logger logger = LoggerFactory.getLogger(TranslationResource.class.getName());

    @Inject
    private TranslationService service;

    @GET
    @Operation(description = "Get translations")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getTranslations() {
        return Response.ok(service.getTranslations()).build();
    }
}
