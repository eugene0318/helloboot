package tobyspring.helloboot;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloControllerTest {

	@Test
	void helloController() {
		HelloController helloController = new HelloController(name -> name);
		String ret = helloController.hello("Test");
		Assertions.assertThat(ret).isEqualTo("Test");
	}

	@Test
	void failsHelloController() {
		HelloController helloController = new HelloController(name -> name);
		Assertions.assertThatThrownBy(() -> {

			String ret = helloController.hello(null);

		}).isInstanceOf(NullPointerException.class);

		Assertions.assertThatThrownBy(() -> {

			String ret = helloController.hello("");

		}).isInstanceOf(NullPointerException.class);
	}

}
