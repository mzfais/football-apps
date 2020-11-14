package id.ac.itn.gibolapps.model;

public class TableItem{
	private int goalsFor;
	private String form;
	private int lost;
	private int won;
	private int playedGames;
	private int position;
	private Team team;
	private int draw;
	private int goalsAgainst;
	private int goalDifference;
	private int points;

	public void setGoalsFor(int goalsFor){
		this.goalsFor = goalsFor;
	}

	public int getGoalsFor(){
		return goalsFor;
	}

	public void setForm(String form){
		this.form = form;
	}

	public String getForm(){
		return form;
	}

	public void setLost(int lost){
		this.lost = lost;
	}

	public int getLost(){
		return lost;
	}

	public void setWon(int won){
		this.won = won;
	}

	public int getWon(){
		return won;
	}

	public void setPlayedGames(int playedGames){
		this.playedGames = playedGames;
	}

	public int getPlayedGames(){
		return playedGames;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public int getPosition(){
		return position;
	}

	public void setTeam(Team team){
		this.team = team;
	}

	public Team getTeam(){
		return team;
	}

	public void setDraw(int draw){
		this.draw = draw;
	}

	public int getDraw(){
		return draw;
	}

	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;
	}

	public int getGoalsAgainst(){
		return goalsAgainst;
	}

	public void setGoalDifference(int goalDifference){
		this.goalDifference = goalDifference;
	}

	public int getGoalDifference(){
		return goalDifference;
	}

	public void setPoints(int points){
		this.points = points;
	}

	public int getPoints(){
		return points;
	}
}
