package PLDataBase;

import java.math.BigInteger;

public class defender extends player{
	public String club;
	public Integer intercept;
	public Integer clearence;
	public Integer tackle;
	public Integer foul;
	
	public defender() {
		super();
	}
	

	public defender(String club, Integer intercept, Integer clearence,
			Integer tackle, Integer foul) {
		super();
		this.club = club;
		this.intercept = intercept;
		this.clearence = clearence;
		this.tackle = tackle;
		this.foul = foul;
	}


	public defender(String name, Integer age, String nationality,
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


	public Integer getIntercept() {
		return intercept;
	}


	public void setIntercept(Integer intercept) {
		this.intercept = intercept;
	}


	public Integer getClearence() {
		return clearence;
	}


	public void setClearence(Integer clearence) {
		this.clearence = clearence;
	}


	public Integer getTackle() {
		return tackle;
	}


	public void setTackle(Integer tackle) {
		this.tackle = tackle;
	}


	public Integer getFoul() {
		return foul;
	}


	public void setFoul(Integer foul) {
		this.foul = foul;
	}


	@Override
	public String toString() {
		return "defender [club=" + club + ", intercept=" + intercept
				+ ", clearence=" + clearence + ", tackle=" + tackle + ", foul="
				+ foul + ", name=" + name + ", age=" + age + ", nationality="
				+ nationality + ", position=" + position + ", transfer_value="
				+ transfer_value + "]";
	}
	
}
