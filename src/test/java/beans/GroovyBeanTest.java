package beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
  locations={"classpath:/beans/groovy-context.groovy"},
  loader = GroovyContextLoader.class)
public class GroovyBeanTest {

	@Autowired
	BeanRefService user;
	
	@Autowired
	SmartBean smartBean;
	
	@Autowired
	ImmutableBean immutableBean;
	
	@Test
	public void beanRefService() throws Exception {
		assertNotNull(user);
		assertNotNull(user.getSimpleService());
		assertNotNull(user.getSimpleService().getBean());
		assertEquals("groovy bean", user.getSimpleService().getBean().getName());
	}
	
	@Test
	public void smartBean() {
		assertNotNull(smartBean);
		assertEquals("SMART Bean", smartBean.getName());
		assertNotNull(smartBean.getBean());
	}
	
	@Test
	public void immutableBean() {
		assertNotNull(immutableBean);
		assertEquals("immutable bean", immutableBean.getName());
		assertEquals("groovy bean", immutableBean.getInternalBeanName());
	}
	
	@Test
	public void listeners() {
		SimpleService simpleService = user.getSimpleService();
		assertEquals(2, simpleService.getListeners().size());
	}
	
}
