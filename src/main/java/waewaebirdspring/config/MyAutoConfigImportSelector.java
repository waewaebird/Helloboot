package waewaebirdspring.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "waewaebirdspring.config.autoconfig.DispatcherServletConfig",
                "waewaebirdspring.config.autoconfig.TomcatWebServerConfig",
        };
    }


}
