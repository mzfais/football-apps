package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class SeasonMD implements Serializable {
	private int id;
	private String startDate;
	private String endDate;
	private int currentMatchday;
	private Object winner;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setCurrentMatchday(int currentMatchday){
		this.currentMatchday = currentMatchday;
	}

	public int getCurrentMatchday(){
		return currentMatchday;
	}

	public void setWinner(Object winner){
		this.winner = winner;
	}

	public Object getWinner(){
		return winner;
	}

	@Override
 	public String toString(){
		return 
			"SeasonMD{" + 
			"id = '" + id + '\'' + 
			",startDate = '" + startDate + '\'' + 
			",endDate = '" + endDate + '\'' + 
			",currentMatchday = '" + currentMatchday + '\'' + 
			",winner = '" + winner + '\'' + 
			"}";
		}
}