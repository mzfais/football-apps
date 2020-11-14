package id.ac.itn.gibolapps.model;

import java.util.List;

public class StandingList{
	private Season season;
	private Competition competition;
	private Filters filters;
	private List<StandingsItem> standings;

	public void setSeason(Season season){
		this.season = season;
	}

	public Season getSeason(){
		return season;
	}

	public void setCompetition(Competition competition){
		this.competition = competition;
	}

	public Competition getCompetition(){
		return competition;
	}

	public void setFilters(Filters filters){
		this.filters = filters;
	}

	public Filters getFilters(){
		return filters;
	}

	public void setStandings(List<StandingsItem> standings){
		this.standings = standings;
	}

	public List<StandingsItem> getStandings(){
		return standings;
	}
}