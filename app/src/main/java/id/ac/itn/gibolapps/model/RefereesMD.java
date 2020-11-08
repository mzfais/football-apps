package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class RefereesMD implements Serializable {
	private int id;
	private String name;
	private Object nationality;

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

	public void setNationality(Object nationality){
		this.nationality = nationality;
	}

	public Object getNationality(){
		return nationality;
	}

	@Override
 	public String toString(){
		return 
			"RefereesMD{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",nationality = '" + nationality + '\'' + 
			"}";
		}
}