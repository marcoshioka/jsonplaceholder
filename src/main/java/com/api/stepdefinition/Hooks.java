package com.api.stepdefinition;

import io.cucumber.java.After;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.commons.io.FilenameUtils;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import java.util.Locale;

public class Hooks {

    private static final Logger LOG = LogManager.getLogger(Hooks.class);

    @Before
    public void testStart(Scenario scenario) {
        String featureName = FilenameUtils.getBaseName(scenario.getUri().toString());
        LOG.info("==========================================================================");
        LOG.info("Feature name: " + featureName.toUpperCase(Locale.ROOT));
        LOG.info("Scenario name: " + scenario.getName());
        LOG.info("Scenario line: " + scenario.getLine());
    }

    @After
    public void testStatus(Scenario scenario) {
        LOG.info("Status:" + scenario.getStatus());
        LOG.info("==========================================================================");
    }
}
