package tobyspring.helloboot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloServiceTest {

	@Test
	void simpleHelloService() {
		SimpleHelloService helloService = new SimpleHelloService();
		String ret = helloService.sayHello("Test");
		org.assertj.core.api.Assertions.assertThat(ret).isEqualTo("Hello Test");
	}

	@Test
	void helloDecorator() {
		HelloDecorator decorator = new HelloDecorator(name -> name);
		String ret = decorator.sayHello("Test");
		org.assertj.core.api.Assertions.assertThat(ret).isEqualTo("*Hello Test");

	}

}
