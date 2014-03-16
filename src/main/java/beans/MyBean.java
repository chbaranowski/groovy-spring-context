package beans;

public class MyBean {

	private String name;

	private boolean isInitialized = false;
	
	public String getName() {
		if(isInitialized)
			return name;
		return null;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void initBeanProperties() {
		isInitialized = true;
	}
	
}
