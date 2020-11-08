package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class Season implements Serializable {
	private int id;
	private String startDate;
	private String endDate;
	private int currentMatchday;

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
}