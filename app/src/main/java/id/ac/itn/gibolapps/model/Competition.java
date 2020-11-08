package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class Competition implements Serializable {
	private int id;
	private Area area;
	private String name;
	private String code;
	private String plan;
	private String lastUpdated;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setArea(Area area){
		this.area = area;
	}

	public Area getArea(){
		return area;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setPlan(String plan){
		this.plan = plan;
	}

	public String getPlan(){
		return plan;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}
}