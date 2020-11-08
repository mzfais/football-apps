package id.ac.itn.gibolapps.model;

import java.io.Serializable;

public class MatchDetailsMD implements Serializable {
	private Head2headMD head2head;
	private MatchMD match;

	public void setHead2head(Head2headMD head2head){
		this.head2head = head2head;
	}

	public Head2headMD getHead2head(){
		return head2head;
	}

	public void setMatch(MatchMD match){
		this.match = match;
	}

	public MatchMD getMatch(){
		return match;
	}

	@Override
 	public String toString(){
		return 
			"MatchDetailsMD{" + 
			"head2head = '" + head2head + '\'' + 
			",match = '" + match + '\'' + 
			"}";
		}
}