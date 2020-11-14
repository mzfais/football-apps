package id.ac.itn.gibolapps.model;

public class Competition{
	private Area area;
	private String lastUpdated;
	private String code;
	private String name;
	private int id;
	private String plan;

	public void setArea(Area area){
		this.area = area;
	}

	public Area getArea(){
		return area;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPlan(String plan){
		this.plan = plan;
	}

	public String getPlan(){
		return plan;
	}
}
