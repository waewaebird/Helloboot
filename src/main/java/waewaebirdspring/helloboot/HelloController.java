package waewaebirdspring.helloboot;

import java.util.Objects;

public class HelloController {
    private final HelloService helloService; // final은 초기화가 필요하다!

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
