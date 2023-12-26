package tobyspring.helloboot;

import java.util.Objects;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements ApplicationContextAware {

	private final HelloService helloService;

	private ApplicationContext applicationContext;

	public HelloController(HelloService helloService) {
		super();
		this.helloService = helloService;
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name") String name) {
		// HelloService helloService = new SimpleHelloService();
		return helloService.sayHello(Objects.requireNonNull(name));
	}

	@GetMapping("/eugene")
	public String eugene() {
		return "Hello eugene";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}

}
