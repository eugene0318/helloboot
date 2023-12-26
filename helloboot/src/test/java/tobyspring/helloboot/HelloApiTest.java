package tobyspring.helloboot;

import java.net.http.HttpHeaders;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HelloApiTest {
	@Test
	void helloApi() {
		TestRestTemplate rest = new TestRestTemplate();
		ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class,
				"Spring");

		// status 200
		Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
		// header(content-type) test/plain
		Assertions.assertThat(res.getHeaders().getFirst(org.springframework.http.HttpHeaders.CONTENT_TYPE))
				.startsWith(MediaType.TEXT_PLAIN_VALUE);
		// body hello spring
		Assertions.assertThat(res.getBody()).isEqualTo("hello Spring");

	}

}
