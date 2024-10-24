package waewaebirdspring.helloboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import waewaebirdspring.config.MySpringBootApplication;

@MySpringBootApplication
public class HellobootApplication {
    /*@Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println("my.name: " + name);
        };
    }*/



    // 디스패처서블릿은 매핑, 파라미터 바인딩역할을 한다
    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }


}
