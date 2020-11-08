package id.ac.itn.gibolapps.model;

import java.util.List;
import java.io.Serializable;

public class MatchesItem implements Serializable {
	private int id;
	private Season season;
	private String utcDate;
	private String status;
	private int matchday;
	private String stage;
	private String group;
	private String lastUpdated;
	private Odds odds;
	private Score score;
	private HomeTeam homeTeam;
	private AwayTeam awayTeam;
	private List<Object> referees;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setSeason(Season season){
		this.season = season;
	}

	public Season getSeason(){
		return season;
	}

	public void setUtcDate(String utcDate){
		this.utcDate = utcDate;
	}

	public String getUtcDate(){
		return utcDate;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setMatchday(int matchday){
		this.matchday = matchday;
	}

	public int getMatchday(){
		return matchday;
	}

	public void setStage(String stage){
		this.stage = stage;
	}

	public String getStage(){
		return stage;
	}

	public void setGroup(String group){
		this.group = group;
	}

	public String getGroup(){
		return group;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setOdds(Odds odds){
		this.odds = odds;
	}

	public Odds getOdds(){
		return odds;
	}

	public void setScore(Score score){
		this.score = score;
	}

	public Score getScore(){
		return score;
	}

	public void setHomeTeam(HomeTeam homeTeam){
		this.homeTeam = homeTeam;
	}

	public HomeTeam getHomeTeam(){
		return homeTeam;
	}

	public void setAwayTeam(AwayTeam awayTeam){
		this.awayTeam = awayTeam;
	}

	public AwayTeam getAwayTeam(){
		return awayTeam;
	}

	public void setReferees(List<Object> referees){
		this.referees = referees;
	}

	public List<Object> getReferees(){
		return referees;
	}
}