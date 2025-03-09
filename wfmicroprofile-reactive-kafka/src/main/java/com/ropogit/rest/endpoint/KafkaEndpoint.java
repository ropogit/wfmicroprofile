package com.ropogit.rest.endpoint;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/kafka")
public class KafkaEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaEndpoint.class);

    @Inject
    @Channel("to-kafka")
    private Emitter<String> em;
    
    @GET
    @Path("/test/{message}")
    public Response sendMessage(@PathParam("message") String message) {
        LOG.info("Starting rest...");
        em.send(message);
        return Response.ok("Message sent").build();
    }

    @Incoming("to-kafka")
    public void processMessage(String message) {
        LOG.info("Message received: {}", message);
    }
}
