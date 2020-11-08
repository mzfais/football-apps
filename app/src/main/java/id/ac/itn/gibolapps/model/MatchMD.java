package id.ac.itn.gibolapps.model;

import java.util.List;
import java.io.Serializable;

public class MatchMD implements Serializable {
	private int id;
	private CompetitionMD competition;
	private SeasonMD season;
	private String utcDate;
	private String status;
	private String venue;
	private int matchday;
	private String stage;
	private String group;
	private String lastUpdated;
	private OddsMD odds;
	private ScoreMD score;
	private HomeTeamMD homeTeam;
	private AwayTeamMD awayTeam;
	private List<RefereesMD> referees;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCompetition(CompetitionMD competition){
		this.competition = competition;
	}

	public CompetitionMD getCompetition(){
		return competition;
	}

	public void setSeason(SeasonMD season){
		this.season = season;
	}

	public SeasonMD getSeason(){
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

	public void setVenue(String venue){
		this.venue = venue;
	}

	public String getVenue(){
		return venue;
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

	public void setOdds(OddsMD odds){
		this.odds = odds;
	}

	public OddsMD getOdds(){
		return odds;
	}

	public void setScore(ScoreMD score){
		this.score = score;
	}

	public ScoreMD getScore(){
		return score;
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

	public void setReferees(List<RefereesMD> referees){
		this.referees = referees;
	}

	public List<RefereesMD> getReferees(){
		return referees;
	}

	@Override
 	public String toString(){
		return 
			"MatchMD{" + 
			"id = '" + id + '\'' + 
			",competition = '" + competition + '\'' + 
			",season = '" + season + '\'' + 
			",utcDate = '" + utcDate + '\'' + 
			",status = '" + status + '\'' + 
			",venue = '" + venue + '\'' + 
			",matchday = '" + matchday + '\'' + 
			",stage = '" + stage + '\'' + 
			",group = '" + group + '\'' + 
			",lastUpdated = '" + lastUpdated + '\'' + 
			",odds = '" + odds + '\'' + 
			",score = '" + score + '\'' + 
			",homeTeam = '" + homeTeam + '\'' + 
			",awayTeam = '" + awayTeam + '\'' + 
			",referees = '" + referees + '\'' + 
			"}";
		}
}