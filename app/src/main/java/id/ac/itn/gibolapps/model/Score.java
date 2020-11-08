package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class Score implements Serializable {
	private String winner;
	private String duration;
	private FullTime fullTime;
	private HalfTime halfTime;
	private ExtraTime extraTime;
	private Penalties penalties;

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

	public void setFullTime(FullTime fullTime){
		this.fullTime = fullTime;
	}

	public FullTime getFullTime(){
		return fullTime;
	}

	public void setHalfTime(HalfTime halfTime){
		this.halfTime = halfTime;
	}

	public HalfTime getHalfTime(){
		return halfTime;
	}

	public void setExtraTime(ExtraTime extraTime){
		this.extraTime = extraTime;
	}

	public ExtraTime getExtraTime(){
		return extraTime;
	}

	public void setPenalties(Penalties penalties){
		this.penalties = penalties;
	}

	public Penalties getPenalties(){
		return penalties;
	}
}