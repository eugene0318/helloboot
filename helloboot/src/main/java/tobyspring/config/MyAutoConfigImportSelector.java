package tobyspring.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

	private final ClassLoader classLoader;

	public MyAutoConfigImportSelector(ClassLoader classLoader) {
		super();
		this.classLoader = classLoader;
	}

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		List<String> autoConfigs = new ArrayList<>();

//		for (String candidates : ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
//			autoConfigs.add(candidates);
//		}
		ImportCandidates.load(MyAutoConfigImportSelector.class, classLoader)
				.forEach(candidate -> autoConfigs.add(candidate));
		// return StreamSupport.stream(candidates.spliterator(),
		// false).toArray(String[]::new);
		// return autoConfigs.toArray(new String[0]);
		// return Arrays.copyOf(autoConfigs.toArray(), autoConfigs.size(),
		// String[].class);
		return autoConfigs.toArray(new String[0]);
	}

}
