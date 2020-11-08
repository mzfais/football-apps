package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class FullTime implements Serializable {
	private int homeTeam;
	private int awayTeam;

	public void setHomeTeam(int homeTeam){
		this.homeTeam = homeTeam;
	}

	public int getHomeTeam(){
		return homeTeam;
	}

	public void setAwayTeam(int awayTeam){
		this.awayTeam = awayTeam;
	}

	public int getAwayTeam(){
		return awayTeam;
	}
}