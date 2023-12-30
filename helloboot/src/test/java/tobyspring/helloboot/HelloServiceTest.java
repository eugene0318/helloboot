package tobyspring.helloboot;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Test
@interface UnitTest {

}

class HelloServiceTest {

	@UnitTest
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
