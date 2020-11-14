package id.ac.itn.gibolapps.model;

import java.util.List;

public class ScorersList{
	private int count;
	private Season season;
	private Competition competition;
	private Filters filters;
	private List<ScorersItem> scorers;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

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

	public void setScorers(List<ScorersItem> scorers){
		this.scorers = scorers;
	}

	public List<ScorersItem> getScorers(){
		return scorers;
	}
}