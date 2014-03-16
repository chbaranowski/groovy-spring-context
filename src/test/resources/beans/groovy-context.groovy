package beans

// load configuration from the classpath
def url = new org.springframework.core.io.ClassPathResource('beans/simple.config').URL;
def config = new ConfigSlurper().parse(url);

beans {
	
	// import a beans form a xml context configuration 
	importBeans("classpath:/beans/default-context.xml")
	
	// use component scan in package beans
	xmlns([ctx:'http://www.springframework.org/schema/context'])
	ctx.'component-scan'('base-package': 'beans')
	
	// define a spring bean
	groovyBean(MyBean) { bean ->
		bean.initMethod = 'initBeanProperties'
		bean.scope = 'prototype'
		name = "groovy bean"
	}
	
	// define a bean the smart way
	smartBean SmartBean, 
		name: "SMART Bean", 
		bean: groovyBean
	
	// define a bean with constructor arguments
	constructorInjectionBean ImmutableBean, "immutable bean", groovyBean, { bean ->
		bean.scope = 'singleton'	
	}
	
	// bean reference to a service, the name of the
	// service bean is defined in the configuration.
	serviceUserBean(BeanRefService) {
		simpleService = ref(config.service)
	}
	
	// define more then one bean e.g. in a loop
	config.listeners.each { listener ->
		"$listener" Listener, name: listener
	}

}