package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.test.context.ContextLoader;

public class GroovyContextLoader implements ContextLoader {

	@Override
	public ApplicationContext loadContext(String... locations) throws Exception {
		GenericGroovyApplicationContext context = new GenericGroovyApplicationContext();
		context.load(locations);
		AnnotationConfigUtils.registerAnnotationConfigProcessors(context);
		context.refresh();
		context.registerShutdownHook();
		return context;
	}

	@Override
	public String[] processLocations(Class<?> clazz, String... locations) {
		return locations;
	}

}
