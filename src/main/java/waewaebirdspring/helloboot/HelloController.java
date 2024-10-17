package waewaebirdspring.helloboot;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
public class HelloController {
    private final HelloService helloService; // 멤버변수, final은 생성할때 초기화를 해주거나 적어도 생성자에서 초기화가 필요하다!
    private final ApplicationContext applicationContext; //나중에 호출되는 메소드라서 시기가 final X

    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext =applicationContext; //스프링 컨테이너

        System.out.println(applicationContext);
    }
    @GetMapping("/hello")
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
