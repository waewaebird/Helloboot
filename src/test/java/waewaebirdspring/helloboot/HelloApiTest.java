package waewaebirdspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


public class HelloApiTest {
    @Test
    void helloApi() {

        TestRestTemplate rest =new TestRestTemplate();

        ResponseEntity<String> res
                = rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");

        // status code 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

        // header(Content-type) text/plain
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);

        //body Hello Speing
        assertThat(res.getBody()).isEqualTo("*Hello Spring*");
    }

    @Test
    void failsHelloApi() {

        TestRestTemplate rest =new TestRestTemplate();

        ResponseEntity<String> res
                = rest.getForEntity("http://localhost:9090 /app/hello?name=", String.class);

        // status code 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

        // header(Content-type) text/plain
        //assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);

        //body Hello Speing
        //assertThat(res.getBody()).isEqualTo("Hello Spring");

    }
}
