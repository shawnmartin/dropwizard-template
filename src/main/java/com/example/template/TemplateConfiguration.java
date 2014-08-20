package com.example.template;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class TemplateConfiguration extends Configuration
{
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "DefaultName";

    @JsonProperty
    public String getTemplate()
    {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template)
    {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName()
    {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name)
    {
        this.defaultName = name;
    }
}