package id.ac.itn.gibolapps.model;

public class Season{
	private Object winner;
	private int currentMatchday;
	private String endDate;
	private int id;
	private String startDate;

	public void setWinner(Object winner){
		this.winner = winner;
	}

	public Object getWinner(){
		return winner;
	}

	public void setCurrentMatchday(int currentMatchday){
		this.currentMatchday = currentMatchday;
	}

	public int getCurrentMatchday(){
		return currentMatchday;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

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
}
