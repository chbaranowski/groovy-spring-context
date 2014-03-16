package beans;

public class ImmutableBean {

	private final String name;
	private final MyBean bean;

	public ImmutableBean(String name, MyBean bean) {
		this.name = name;
		this.bean = bean;
	}

	public String getName() {
		return name;
	}
	
	public String getInternalBeanName() {
		return bean.getName();
	}
	
}
