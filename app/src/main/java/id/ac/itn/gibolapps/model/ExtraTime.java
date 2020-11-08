package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class ExtraTime implements Serializable {
	private Object homeTeam;
	private Object awayTeam;

	public void setHomeTeam(Object homeTeam){
		this.homeTeam = homeTeam;
	}

	public Object getHomeTeam(){
		return homeTeam;
	}

	public void setAwayTeam(Object awayTeam){
		this.awayTeam = awayTeam;
	}

	public Object getAwayTeam(){
		return awayTeam;
	}
}