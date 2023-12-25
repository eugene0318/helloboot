package tobyspring.helloboot;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
public class HelloController {

	private final HelloService helloService;

	public HelloController(HelloService helloService) {
		super();
		this.helloService = helloService;
	}

	@GetMapping
	@ResponseBody
	public String hello(@RequestParam(value = "name") String name) {
		// HelloService helloService = new SimpleHelloService();
		return helloService.sayHello(Objects.requireNonNull(name));
	}

	@GetMapping("/eugene")
	public String eugene() {
		return "Hello eugene";
	}
}
