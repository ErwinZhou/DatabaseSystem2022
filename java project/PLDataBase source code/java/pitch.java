package PLDataBase;

public class pitch {
	public String name;
	public String place;
	public String club;
	
	public pitch() {
		super();
	}

	public pitch(String name, String place, String club) {
		super();
		this.name = name;
		this.place = place;
		this.club = club;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "pitch [name=" + name + ", place=" + place + ", club=" + club
				+ "]";
	}
	
	

}
