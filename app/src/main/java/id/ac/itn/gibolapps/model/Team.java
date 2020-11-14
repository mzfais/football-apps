package id.ac.itn.gibolapps.model;

public class Team{
	private String crestUrl;
	private String name;
	private int id;

	public void setCrestUrl(String crestUrl){
		this.crestUrl = crestUrl;
	}

	public String getCrestUrl(){
		return crestUrl;
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
}
