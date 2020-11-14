package id.ac.itn.gibolapps.model;

import java.util.List;

public class StandingsItem{
	private String stage;
	private String type;
	private List<TableItem> table;
	private String group;

	public void setStage(String stage){
		this.stage = stage;
	}

	public String getStage(){
		return stage;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTable(List<TableItem> table){
		this.table = table;
	}

	public List<TableItem> getTable(){
		return table;
	}

	public void setGroup(String group){
		this.group = group;
	}

	public String getGroup(){
		return group;
	}
}