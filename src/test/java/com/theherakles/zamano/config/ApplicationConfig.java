package com.theherakles.zamano.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theherakles.zamano.enums.BrowserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ApplicationConfig {
    @JsonProperty("project-name")
    private String projectName;

    @JsonProperty("build")
    private String build;

    @JsonProperty("main-page-url")
    private String mainPageUrl;

    @JsonProperty("url-to-navigate")
    private String urlToNavigate;

    @JsonProperty("browser-type-id")
    private int browserTypeId;

    @JsonProperty("remote-grid-url")
    private String remoteGridUrl;

    @JsonProperty("api-base-url")
    private String apiBaseURL;

    public BrowserType getBrowserType(){
        return BrowserType.getById(browserTypeId);
    }


}
