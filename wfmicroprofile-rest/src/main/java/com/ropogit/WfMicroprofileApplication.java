package com.ropogit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("")
public class WfMicroprofileApplication extends Application {
    private static final Logger LOG = LoggerFactory.getLogger(WfMicroprofileApplication.class);
}
