package com.flipkart;

import com.flipkart.health.TemplateHealthCheck;
import com.flipkart.resources.InsertSQL;
import com.flipkart.resources.RestAPICalls;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.flipkart.resources.HelloWorldResource;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloWorld";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HelloWorldConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        System.out.println(configuration.getTemplate());
        final InsertSQL insert= new InsertSQL(
                configuration.getJdbcURL(),
                configuration.getUsername_sql(),
                configuration.getPassword_sql());
        final RestAPICalls restAPICalls = new RestAPICalls(
                configuration.getUSER_AGENT(),
                configuration.getGET_URL(),
                configuration.getPOST_URL(),
                configuration.getPOST_PARAMS()
        );

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(insert);
        environment.jersey().register(restAPICalls);
        // TODO: implement application
    }

}
