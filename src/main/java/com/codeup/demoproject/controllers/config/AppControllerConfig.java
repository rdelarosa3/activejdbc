package com.codeup.demoproject.controllers.config;

import com.codeup.demoproject.controllers.AdController;
import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.controller_filters.DBConnectionFilter;

public class AppControllerConfig extends AbstractControllerConfig {
    public void init(AppContext context) {
        add(new DBConnectionFilter("default", true)).to(AdController.class);
    }
}