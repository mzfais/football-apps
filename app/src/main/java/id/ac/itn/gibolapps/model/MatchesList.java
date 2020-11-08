package id.ac.itn.gibolapps.model;

import java.util.List;
import java.io.Serializable;

public class MatchesList implements Serializable {
	private int count;
	private Filters filters;
	private Competition competition;
	private List<MatchesItem> matches;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setFilters(Filters filters){
		this.filters = filters;
	}

	public Filters getFilters(){
		return filters;
	}

	public void setCompetition(Competition competition){
		this.competition = competition;
	}

	public Competition getCompetition(){
		return competition;
	}

	public void setMatches(List<MatchesItem> matches){
		this.matches = matches;
	}

	public List<MatchesItem> getMatches(){
		return matches;
	}
}