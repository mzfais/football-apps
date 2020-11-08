package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class CompetitionMD implements Serializable {
	private int id;
	private String name;
	private AreaMD area;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setArea(AreaMD area){
		this.area = area;
	}

	public AreaMD getArea(){
		return area;
	}

	@Override
 	public String toString(){
		return 
			"CompetitionMD{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",area = '" + area + '\'' + 
			"}";
		}
}