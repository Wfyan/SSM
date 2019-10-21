package net.sshtest.service;

import net.sshtest.entity.Announcement;
import net.sshtest.entity.User;

import java.util.List;

public interface IUserService {
	
	//注册
	public void register(User user);
	
	//登录
	public User login(User user);
	
	//查询所有用户
	public List<User> queryAll();
	
	//修改用户信息
	public void updateUserinfo(User user);
	
	//修改密码
	public void updatePassword(User user,int userid);
	
	//删除用户（修改用户状态）
	public void deleteUser(User user);
	
	//按用户详细信息查找用户
	public User userQueryBydetail(User user);
	
	//查询所有公告
	public List<Announcement> queryAllanno();
	
	//添加一条公告
	public void addAnnounce(Announcement announcement);

	//按id查公告
	public Announcement queryAnnoByid(Announcement announcement);
}
