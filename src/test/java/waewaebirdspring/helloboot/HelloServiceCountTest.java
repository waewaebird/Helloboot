package waewaebirdspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloServiceCountTest {
    @Autowired
    HelloService helloService;

    @Autowired
    HelloRepository helloRepository;


    @Test
    void sayHelloIncreaseCount() {
        IntStream.range(1, 10).forEach(count -> {
            helloService.sayHello("Wae");
            Assertions.assertThat(helloRepository.countOf("Wae")).isEqualTo(count);
        });
    }
}
