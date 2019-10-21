package net.sshtest.entity;

public class Announcement {
	
	private int announcementid;
	private String announcementTitle;
	private String announcementDetail;
	private User userid;
	private String announcementTime;
	
	public int getAnnouncementid() {
		return announcementid;
	}
	public void setAnnouncementid(int announcementid) {
		this.announcementid = announcementid;
	}
	public String getAnnouncementTitle() {
		return announcementTitle;
	}
	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}
	public String getAnnouncementDetail() {
		return announcementDetail;
	}
	public void setAnnouncementDetail(String announcementDetail) {
		this.announcementDetail = announcementDetail;
	}
	public String getAnnouncementTime() {
		return announcementTime;
	}
	public void setAnnouncementTime(String announcementTime) {
		this.announcementTime = announcementTime;
	}
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}

}
