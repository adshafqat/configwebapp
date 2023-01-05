package com.zaynsolutions.config;

public class BackendServer {

    private final String url;
    private final String port;

    public BackendServer() {
        this.url = null;
        this.port = null;
    }

    public BackendServer(String url, String port) {
        this.url = url;
        this.port = port;
    }

    public String getUrl() {
        return url;
    }
  
      public String getPort() {
        return port;
    }
}
