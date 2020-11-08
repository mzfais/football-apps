package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class AreaMD implements Serializable {
	private String name;
	private String code;
	private Object ensignUrl;

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

	public void setEnsignUrl(Object ensignUrl){
		this.ensignUrl = ensignUrl;
	}

	public Object getEnsignUrl(){
		return ensignUrl;
	}

	@Override
 	public String toString(){
		return 
			"AreaMD{" + 
			"name = '" + name + '\'' + 
			",code = '" + code + '\'' + 
			",ensignUrl = '" + ensignUrl + '\'' + 
			"}";
		}
}