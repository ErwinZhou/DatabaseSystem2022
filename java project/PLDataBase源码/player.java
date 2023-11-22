package PLDataBase;



public class player {
	public String name;
	public Integer age;
	public String nationality;
	public String position;
	public Integer transfer_value;
	public String club;
	
	public player() {
		super();
	}

	public player(String name, Integer age, String nationality,
			String position, Integer transfer_value, String club) {
		super();
		this.name = name;
		this.age = age;
		this.nationality = nationality;
		this.position = position;
		this.transfer_value = transfer_value;
		this.club = club;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getTransfer_value() {
		return transfer_value;
	}

	public void setTransfer_value(Integer transfer_value) {
		this.transfer_value = transfer_value;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "player [name=" + name + ", age=" + age + ", nationality="
				+ nationality + ", position=" + position + ", transfer_value="
				+ transfer_value + ", club=" + club + "]";
	}
	
	
	
	

}
