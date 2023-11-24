package PLDataBase;

import java.math.BigInteger;

public class goalkeeper extends player{
	public String club;
	public Integer save;
	public Integer clean_sheets;
	
	public goalkeeper() {
		super();
	}
	

	public goalkeeper(String club, Integer save, Integer clean_sheets) {
		super();
		this.club = club;
		this.save = save;
		this.clean_sheets = clean_sheets;
	}


	public goalkeeper(String name, Integer age, String nationality,
			String position, Integer transfer_value, String club) {
		super(name, age, nationality, position, transfer_value, club);
		// TODO Auto-generated constructor stub
	}


	public String getClub() {
		return club;
	}


	public void setClub(String club) {
		this.club = club;
	}


	public Integer getSave() {
		return save;
	}


	public void setSave(Integer save) {
		this.save = save;
	}


	public Integer getClean_sheets() {
		return clean_sheets;
	}


	public void setClean_sheets(Integer clean_sheets) {
		this.clean_sheets = clean_sheets;
	}


	@Override
	public String toString() {
		return "goalkeeper [club=" + club + ", save=" + save
				+ ", clean_sheets=" + clean_sheets + ", name=" + name
				+ ", age=" + age + ", nationality=" + nationality
				+ ", position=" + position + ", transfer_value="
				+ transfer_value + "]";
	}


	
	
	
	

}
