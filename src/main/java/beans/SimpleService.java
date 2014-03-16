package beans;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("simpleJavaServiceBean")
public class SimpleService {

	@Resource(name = "groovyBean")
	private MyBean bean;
	
	@Autowired
	private List<Listener> listeners;

	public MyBean getBean() {
		return bean;
	}

	public void setBean(MyBean bean) {
		this.bean = bean;
	}

	public List<Listener> getListeners() {
		return listeners;
	}

	public void setListeners(List<Listener> listeners) {
		this.listeners = listeners;
	}
	
}
