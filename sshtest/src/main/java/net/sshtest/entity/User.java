package net.sshtest.entity;

public class User {
	private int userid;
	private String username;
	private String password;
	private String passwordnew;
	private String passwordagain;
	private String gender;
	private String phoneNumber;
	private String email;
	private String birthplace;
	private int realNameAuthenticationid;
	private Role roleid;
	private String registDate;
	private StateInfo state;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public int getRealNameAuthenticationid() {
		return realNameAuthenticationid;
	}
	public void setRealNameAuthenticationid(int realNameAuthenticationid) {
		this.realNameAuthenticationid = realNameAuthenticationid;
	}
	public Role getRoleid() {
		return roleid;
	}
	public void setRoleid(Role roleid) {
		this.roleid = roleid;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getPasswordagain() {
		return passwordagain;
	}
	public void setPasswordagain(String passwordagain) {
		this.passwordagain = passwordagain;
	}
	public String getPasswordnew() {
		return passwordnew;
	}
	public void setPasswordnew(String passwordnew) {
		this.passwordnew = passwordnew;
	}
	public StateInfo getState() {
		return state;
	}
	public void setState(StateInfo state) {
		this.state = state;
	}
	
//	@Override
//	public String toString(){
//		return super.toString();
//	}
}
