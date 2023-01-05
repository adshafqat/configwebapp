
package com.zaynsolutions.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("backendserver")
public class BackendProperties {

    private String url = null;
    private String port = null;

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
