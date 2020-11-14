package id.ac.itn.gibolapps.model;

public class ScorersItem{
	private int numberOfGoals;
	private Team team;
	private Player player;

	public void setNumberOfGoals(int numberOfGoals){
		this.numberOfGoals = numberOfGoals;
	}

	public int getNumberOfGoals(){
		return numberOfGoals;
	}

	public void setTeam(Team team){
		this.team = team;
	}

	public Team getTeam(){
		return team;
	}

	public void setPlayer(Player player){
		this.player = player;
	}

	public Player getPlayer(){
		return player;
	}
}
