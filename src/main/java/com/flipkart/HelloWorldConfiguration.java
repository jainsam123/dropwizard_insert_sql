package com.flipkart;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldConfiguration extends Configuration {
    private String template;

    private String defaultName;

    private String jdbcURL;
    private String username_sql;
    private String password_sql;
    private String base_url;
    private String get_path;
    private String post_path;

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



    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

    public void setUsername_sql(String username_sql) {
        this.username_sql = username_sql;
    }

    public void setPassword_sql(String password_sql) {
        this.password_sql = password_sql;
    }


    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getGet_path() {
        return get_path;
    }

    public void setGet_path(String get_path) {
        this.get_path = get_path;
    }

    public String getPost_path() {
        return post_path;
    }

    public void setPost_path(String post_path) {
        this.post_path = post_path;
    }
}