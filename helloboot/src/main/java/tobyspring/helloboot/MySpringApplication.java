package tobyspring.helloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {

	public static void run(Class<?> applicationClass, String[] args) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				// TODO Auto-generated method stub
				super.onRefresh();
				// 서블릿 펙토리 : 서블릿 컨테이너를 만드는 것을 쉽게 도와줍니다.
				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
				dispatcherServlet.setApplicationContext(this);
				// serverFactory.getWebServer : 서블릿 컨테이너 생성하는 메소드입니다.
				// 따라서 webServer 가 서블릿 컨테이너 입니다.
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet", dispatcherServlet // DispatcherServlet이
																						// 작업을
																						// 위임할
																						// applicationContext를
																						// 등록
					).addMapping("/*"); // 모든 요청을 다 받는다.
				});
				webServer.start();
			}
		}; // 스프링 컨테이너 생성
//		applicationContext.registerBean(HelloController.class); // 메타정보를 넣어 Bean을 생성
//		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.register(applicationClass);
		applicationContext.refresh(); // Bean을 만드는 명령어

	}
}
