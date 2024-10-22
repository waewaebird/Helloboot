package waewaebirdspring.helloboot;

import org.springframework.boot.SpringApplication;
import waewaebirdspring.config.MySpringBootApplication;

@MySpringBootApplication
public class HellobootApplication {
    // 디스패처서블릿은 매핑, 파라미터 바인딩역할을 한다
    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }


}
