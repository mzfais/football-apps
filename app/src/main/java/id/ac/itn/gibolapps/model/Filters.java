package id.ac.itn.gibolapps.model;

import java.util.List;
import java.io.Serializable;

public class Filters implements Serializable {
	private List<String> status;

	public void setStatus(List<String> status){
		this.status = status;
	}

	public List<String> getStatus(){
		return status;
	}
}