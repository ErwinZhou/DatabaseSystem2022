package PLDataBase;

import java.sql.Timestamp;

public class match {
	public Timestamp kick_off_time;
	public String pitch;
	public String referee;
	public String home_team;
	public String visiting_team;
	
	public match() {
		super();
	}

	public match(Timestamp kick_off_time, String pitch, String referee,
			String home_team, String visiting_team) {
		super();
		this.kick_off_time = kick_off_time;
		this.pitch = pitch;
		this.referee = referee;
		this.home_team = home_team;
		this.visiting_team = visiting_team;
	}

	public Timestamp getKick_off_time() {
		return kick_off_time;
	}

	public void setKick_off_time(Timestamp kick_off_time) {
		this.kick_off_time = kick_off_time;
	}

	public String getPitch() {
		return pitch;
	}

	public void setPitch(String pitch) {
		this.pitch = pitch;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public String getHome_team() {
		return home_team;
	}

	public void setHome_team(String home_team) {
		this.home_team = home_team;
	}

	public String getVisiting_team() {
		return visiting_team;
	}

	public void setVisiting_team(String visiting_team) {
		this.visiting_team = visiting_team;
	}

	@Override
	public String toString() {
		return "match [kick_off_time=" + kick_off_time + ", pitch=" + pitch
				+ ", referee=" + referee + ", home_team=" + home_team
				+ ", visiting_team=" + visiting_team + "]";
	}
	
	
	
	
}
