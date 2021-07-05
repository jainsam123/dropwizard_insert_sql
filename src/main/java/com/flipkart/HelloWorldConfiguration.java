package com.flipkart;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class HelloWorldConfiguration extends Configuration {
    private String template;

    private String defaultName = "Straw";

    private String jdbcURL;
    private String username_sql;
    private String password_sql;

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
    public void setDefaultName(String name) {
        this.defaultName = name;
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
}