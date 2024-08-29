package PLDataBase;

import java.math.BigInteger;

public class midfilder extends player{
	public String club;
	public Integer pass;
	public Integer successful_pass;
	public Integer assist;
	public Integer intercept;
	public Integer tackle;
	public Integer goal;
	public Integer foul;
	
	public midfilder() {
		super();
	}

	public midfilder(String name, Integer age, String nationality,
			String position, Integer transfer_value, String club) {
		super(name, age, nationality, position, transfer_value, club);
		// TODO Auto-generated constructor stub
	}

	public midfilder(String club, Integer pass, Integer successful_pass,
			Integer assist, Integer intercept, Integer tackle, Integer goal,
			Integer foul) {
		super();
		this.club = club;
		this.pass = pass;
		this.successful_pass = successful_pass;
		this.assist = assist;
		this.intercept = intercept;
		this.tackle = tackle;
		this.goal = goal;
		this.foul = foul;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Integer getPass() {
		return pass;
	}

	public void setPass(Integer pass) {
		this.pass = pass;
	}

	public Integer getSuccessful_pass() {
		return successful_pass;
	}

	public void setSuccessful_pass(Integer successful_pass) {
		this.successful_pass = successful_pass;
	}

	public Integer getAssist() {
		return assist;
	}

	public void setAssist(Integer assist) {
		this.assist = assist;
	}

	public Integer getIntercept() {
		return intercept;
	}

	public void setIntercept(Integer intercept) {
		this.intercept = intercept;
	}

	public Integer getTackle() {
		return tackle;
	}

	public void setTackle(Integer tackle) {
		this.tackle = tackle;
	}

	public Integer getGoal() {
		return goal;
	}

	public void setGoal(Integer goal) {
		this.goal = goal;
	}

	public Integer getFoul() {
		return foul;
	}

	public void setFoul(Integer foul) {
		this.foul = foul;
	}

	@Override
	public String toString() {
		return "midfilder [club=" + club + ", pass=" + pass
				+ ", successful_pass=" + successful_pass + ", assist=" + assist
				+ ", intercept=" + intercept + ", tackle=" + tackle + ", goal="
				+ goal + ", foul=" + foul + ", name=" + name + ", age=" + age
				+ ", nationality=" + nationality + ", position=" + position
				+ ", transfer_value=" + transfer_value + "]";
	}
	
}
