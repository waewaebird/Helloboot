package waewaebirdspring.deletedconfig.autoconfig;

import waewaebirdspring.deletedconfig.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "server")
public class ServerProperties {
    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private String contextPath;

    private int port;
}
