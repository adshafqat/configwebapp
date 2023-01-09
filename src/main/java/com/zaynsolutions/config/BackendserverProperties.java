
package com.zaynsolutions.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="backendserver")
public class BackendserverProperties {

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
