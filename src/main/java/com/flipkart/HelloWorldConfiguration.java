package com.flipkart;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldConfiguration extends Configuration {
    private String template;

    private String defaultName;

    private String jdbcURL;
    private String username_sql;
    private String password_sql;
    private String USER_AGENT ;
    private String GET_URL;
    private String POST_URL ;

    private String POST_PARAMS;

    public HelloWorldConfiguration() {
    }

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }


    @JsonProperty
    public String getJdbcURL() {
        return jdbcURL;
    }

    @JsonProperty
    public String getUsername_sql() {
        return username_sql;
    }

    @JsonProperty
    public String getPassword_sql() {
        return password_sql;
    }

    @JsonProperty
    public String getPOST_PARAMS() {
        return POST_PARAMS;
    }

    @JsonProperty
    public String getPOST_URL() {
        return POST_URL;
    }

    @JsonProperty
    public String getUSER_AGENT() {
        return USER_AGENT;
    }

    public String getGET_URL() {
        return GET_URL;
    }

}