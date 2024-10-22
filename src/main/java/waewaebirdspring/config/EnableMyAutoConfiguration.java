package waewaebirdspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import waewaebirdspring.config.autoconfig.DispatcherServletConfig;
import waewaebirdspring.config.autoconfig.TomcatWebServerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // 클래스 인터페이스 ENUM
@Configuration
@ComponentScan
@Import(MyAutoConfigImportSelector.class)
public @interface EnableMyAutoConfiguration {
}
