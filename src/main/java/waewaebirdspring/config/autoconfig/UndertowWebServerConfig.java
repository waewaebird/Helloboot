package waewaebirdspring.config.autoconfig;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import waewaebirdspring.config.ConditionalMyOnClass;

@ConditionalMyOnClass("io.undertow.undertow")
public class UndertowWebServerConfig {

    @Bean("undertowWebServerConfig")
    public ServletWebServerFactory servletWebServerFactory() {
        return new UndertowServletWebServerFactory();
    }
}
