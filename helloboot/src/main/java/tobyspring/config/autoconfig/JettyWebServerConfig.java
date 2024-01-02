package tobyspring.config.autoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import ch.qos.logback.core.joran.conditional.Condition;
import tobyspring.config.ConditionalMyOnClass;
import tobyspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
//@Conditional(JettyWebServerConfig.JettyCondition.class)
public class JettyWebServerConfig {

	@Bean("jettyWebServerFactory")
	public ServletWebServerFactory servletWebServerFactory() {
		return new JettyServletWebServerFactory();
	}

//	static class JettyCondition implements org.springframework.context.annotation.Condition {
//
//		@Override
//		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//			// TODO Auto-generated method stub
//			return ClassUtils.isPresent("org.eclipse.jetty.server.Server", context.getClassLoader());
//		}
//
//	}
}
