package de.mkienitz.bachelorarbeit.localization;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/translations")
@RequestScoped
public class TranslationResource {

    private static final Logger logger = LoggerFactory.getLogger(TranslationResource.class.getName());

    @Inject
    private TranslationService service;

    @GET
    @Operation(description = "Get translations")
    @Traced(operationName = "TranslationResource.getTranslations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTranslations() {
        return Response.ok(service.getTranslations()).build();
    }
}
