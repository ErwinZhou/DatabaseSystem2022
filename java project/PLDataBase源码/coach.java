package PLDataBase;

public class coach {
	public String name;
	public String club;
	public String nationality;
	public Integer age;
	
	public coach() {
		super();
	}
	public coach(String name, String club, String nationality, Integer age) {
		super();
		this.name = name;
		this.club = club;
		this.nationality = nationality;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "coach [name=" + name + ", club=" + club + ", nationality="
				+ nationality + ", age=" + age + "]";
	}
	
	

}
