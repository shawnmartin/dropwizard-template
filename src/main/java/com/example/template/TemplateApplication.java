package com.example.template;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.template.resources.TemplateResource;
import com.example.template.health.TemplateHealthCheck;

public class TemplateApplication extends Application<TemplateConfiguration>
{
    public static void main(String[] args) throws Exception
    {
        new TemplateApplication().run(args);
    }

    @Override
    public String getName()
    {
        return "template";
    }

    @Override
    public void initialize(Bootstrap<TemplateConfiguration> bootstrap)
    {
        // nothing to do yet
    }

    @Override
    public void run(TemplateConfiguration configuration, Environment environment)
    {
    	final TemplateResource resource = new TemplateResource(configuration.getTemplate(), configuration.getDefaultName());
    	final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
    	
    	environment.jersey().register(resource);
    	environment.healthChecks().register("template", healthCheck);
    }

}