package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class AwayTeamMD implements Serializable {
	private int id;
	private String name;
	private int wins;
	private int draws;
	private int losses;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setWins(int wins){
		this.wins = wins;
	}

	public int getWins(){
		return wins;
	}

	public void setDraws(int draws){
		this.draws = draws;
	}

	public int getDraws(){
		return draws;
	}

	public void setLosses(int losses){
		this.losses = losses;
	}

	public int getLosses(){
		return losses;
	}

	@Override
 	public String toString(){
		return 
			"AwayTeamMD{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",wins = '" + wins + '\'' + 
			",draws = '" + draws + '\'' + 
			",losses = '" + losses + '\'' + 
			"}";
		}
}