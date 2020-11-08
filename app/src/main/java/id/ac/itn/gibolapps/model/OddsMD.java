package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class OddsMD implements Serializable {
	private String msg;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	@Override
 	public String toString(){
		return 
			"OddsMD{" + 
			"msg = '" + msg + '\'' + 
			"}";
		}
}