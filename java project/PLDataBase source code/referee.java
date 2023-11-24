package PLDataBase;

public class referee {
	public String name;
	public String sex;
	
	public referee() {
		super();
	}

	public referee(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "referee [name=" + name + ", sex=" + sex + "]";
	}
	
	

}
