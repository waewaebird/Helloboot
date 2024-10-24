package waewaebirdspring.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import waewaebirdspring.config.ConditionalMyOnClass;
import waewaebirdspring.config.EnableMyConfigurationProperties;
import waewaebirdspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {
    /*@Value("${contextPath:}")
    String contextPath;

    @Value("${port:8080}")
    int port;
*/
    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        factory.setContextPath(properties.getContextPath());
        factory.setPort(properties.getPort());

        return factory;
    }

/*    @Bean
    public ServerProperties serverProperties(Environment environment) {
        ServerProperties properties = new ServerProperties();

        properties.setContextPath(environment.getProperty("contextPath"));
        properties.setPort(Integer.parseInt(environment.getProperty("port")));

        return properties;
    }*/
}
