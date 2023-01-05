
package com.zaynsolutions.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Component
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("backendserver")
public class BackendProperties {

    private String url;
    private String port;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
  
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
