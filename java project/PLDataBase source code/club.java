package PLDataBase;

public class club {
	public String name;
	public String coach;
	public Integer rank;
	public String area;
	public Integer points;
	public String home_stadium;
	
	public club() {
		super();
	}

	public club(String name, String coach, Integer rank, String area,
			Integer points, String home_stadium) {
		super();
		this.name = name;
		this.coach = coach;
		this.rank = rank;
		this.area = area;
		this.points = points;
		this.home_stadium = home_stadium;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getHome_stadium() {
		return home_stadium;
	}

	public void setHome_stadium(String home_stadium) {
		this.home_stadium = home_stadium;
	}

	@Override
	public String toString() {
		return "club [name=" + name + ", coach=" + coach + ", rank=" + rank
				+ ", area=" + area + ", points=" + points + ", home_stadium="
				+ home_stadium + "]";
	}
	
	
	

}
