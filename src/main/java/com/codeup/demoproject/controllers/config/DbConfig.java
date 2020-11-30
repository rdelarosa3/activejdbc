package com.codeup.demoproject.controllers.config;
import org.javalite.activeweb.AbstractDBConfig;
import org.javalite.activeweb.AppContext;
public class DbConfig extends AbstractDBConfig {

    public void init(AppContext context) {
        configFile("/database.properties");
        environment("development",true).jdbc("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost/active_jdbc_db", "root", "root");

    }
}