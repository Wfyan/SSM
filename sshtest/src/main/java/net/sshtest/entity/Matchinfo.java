package net.sshtest.entity;

public class Matchinfo {
	
	private int matchid;
	private Equipment equipmentid;
	private StateInfo state;
	private User userid;
	private Site siteid;
	private String matchTime;
	private String matchPerson;
	private String matchName;
	private int matchState;
	
	public int getMatchid() {
		return matchid;
	}
	public void setMatchid(int matchid) {
		this.matchid = matchid;
	}
	public Equipment getEquipmentid() {
		return equipmentid;
	}
	public void setEquipmentid(Equipment equipmentid) {
		this.equipmentid = equipmentid;
	}
	public StateInfo getState() {
		return state;
	}
	public void setState(StateInfo state) {
		this.state = state;
	}
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	public Site getSiteid() {
		return siteid;
	}
	public void setSiteid(Site siteid) {
		this.siteid = siteid;
	}
	public String getMatchTime() {
		return matchTime;
	}
	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}
	public String getMatchPerson() {
		return matchPerson;
	}
	public void setMatchPerson(String matchPerson) {
		this.matchPerson = matchPerson;
	}
	public String getMatchName() {
		return matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	public int getMatchState() {
		return matchState;
	}
	public void setMatchState(int matchState) {
		this.matchState = matchState;
	}
	
	
	
	
}
