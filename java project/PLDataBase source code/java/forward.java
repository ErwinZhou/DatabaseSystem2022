package PLDataBase;

import java.math.BigInteger;

public class forward extends player{
	public String club;
	public Integer shoot;
	public Integer goal;
	public Integer assist;
	public Integer penalty_kick;
	
	public forward() {
		super();
	}
	

	public forward(String club, Integer shoot, Integer goal, Integer assist,
			Integer penalty_kick) {
		super();
		this.club = club;
		this.shoot = shoot;
		this.goal = goal;
		this.assist = assist;
		this.penalty_kick = penalty_kick;
	}


	public forward(String name, Integer age, String nationality,
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


	public Integer getShoot() {
		return shoot;
	}


	public void setShoot(Integer shoot) {
		this.shoot = shoot;
	}


	public Integer getGoal() {
		return goal;
	}


	public void setGoal(Integer goal) {
		this.goal = goal;
	}


	public Integer getAssist() {
		return assist;
	}


	public void setAssist(Integer assist) {
		this.assist = assist;
	}


	public Integer getPenalty_kick() {
		return penalty_kick;
	}


	public void setPenalty_kick(Integer penalty_kick) {
		this.penalty_kick = penalty_kick;
	}


	@Override
	public String toString() {
		return "forward [club=" + club + ", shoot=" + shoot + ", goal=" + goal
				+ ", assist=" + assist + ", penalty_kick=" + penalty_kick
				+ ", name=" + name + ", age=" + age + ", nationality="
				+ nationality + ", position=" + position + ", transfer_value="
				+ transfer_value + "]";
	}


	

	
}
