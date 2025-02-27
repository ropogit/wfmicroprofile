package com.ropogit.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class TestRestEpImpl implements TestRestEp {
    private static final Logger LOG = LoggerFactory.getLogger(TestRestEpImpl.class);

    @Inject
    @ConfigProperty(name = "TEST", defaultValue = "failed")
    private String configData;

    @Override
    public Response microTest() {
        LOG.info("### ping: {}", configData);
        return Response.ok("DATA: " + configData).build();
    }

}
