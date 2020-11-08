package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class ScoreMD implements Serializable {
	private String winner;
	private String duration;
	private FullTimeMD fullTime;
	private HalfTimeMD halfTime;
	private ExtraTimeMD extraTime;
	private PenaltiesMD penalties;

	public void setWinner(String winner){
		this.winner = winner;
	}

	public String getWinner(){
		return winner;
	}

	public void setDuration(String duration){
		this.duration = duration;
	}

	public String getDuration(){
		return duration;
	}

	public void setFullTime(FullTimeMD fullTime){
		this.fullTime = fullTime;
	}

	public FullTimeMD getFullTime(){
		return fullTime;
	}

	public void setHalfTime(HalfTimeMD halfTime){
		this.halfTime = halfTime;
	}

	public HalfTimeMD getHalfTime(){
		return halfTime;
	}

	public void setExtraTime(ExtraTimeMD extraTime){
		this.extraTime = extraTime;
	}

	public ExtraTimeMD getExtraTime(){
		return extraTime;
	}

	public void setPenalties(PenaltiesMD penalties){
		this.penalties = penalties;
	}

	public PenaltiesMD getPenalties(){
		return penalties;
	}

	@Override
 	public String toString(){
		return 
			"ScoreMD{" + 
			"winner = '" + winner + '\'' + 
			",duration = '" + duration + '\'' + 
			",fullTime = '" + fullTime + '\'' + 
			",halfTime = '" + halfTime + '\'' + 
			",extraTime = '" + extraTime + '\'' + 
			",penalties = '" + penalties + '\'' + 
			"}";
		}
}