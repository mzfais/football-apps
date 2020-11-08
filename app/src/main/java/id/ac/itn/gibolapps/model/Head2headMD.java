package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class Head2headMD implements Serializable {
	private int numberOfMatches;
	private int totalGoals;
	private HomeTeamMD homeTeam;
	private AwayTeamMD awayTeam;

	public void setNumberOfMatches(int numberOfMatches){
		this.numberOfMatches = numberOfMatches;
	}

	public int getNumberOfMatches(){
		return numberOfMatches;
	}

	public void setTotalGoals(int totalGoals){
		this.totalGoals = totalGoals;
	}

	public int getTotalGoals(){
		return totalGoals;
	}

	public void setHomeTeam(HomeTeamMD homeTeam){
		this.homeTeam = homeTeam;
	}

	public HomeTeamMD getHomeTeam(){
		return homeTeam;
	}

	public void setAwayTeam(AwayTeamMD awayTeam){
		this.awayTeam = awayTeam;
	}

	public AwayTeamMD getAwayTeam(){
		return awayTeam;
	}

	@Override
 	public String toString(){
		return 
			"Head2headMD{" + 
			"numberOfMatches = '" + numberOfMatches + '\'' + 
			",totalGoals = '" + totalGoals + '\'' + 
			",homeTeam = '" + homeTeam + '\'' + 
			",awayTeam = '" + awayTeam + '\'' + 
			"}";
		}
}