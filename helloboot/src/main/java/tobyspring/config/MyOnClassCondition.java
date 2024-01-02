package tobyspring.config;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import com.fasterxml.jackson.databind.util.ClassUtil;

public class MyOnClassCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Map<String, Object> attrs = metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName());
		String value = (String) attrs.get("value");
		// TODO Auto-generated method stub
		return ClassUtils.isPresent(value, context.getClassLoader());
	}

}
