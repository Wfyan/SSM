package net.sshtest.service.impl;

import net.sshtest.dao.IUserDao;
import net.sshtest.entity.Announcement;
import net.sshtest.entity.User;
import net.sshtest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userdao;
	
	public IUserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(IUserDao userdao) {
		this.userdao = userdao;
	}
	
	//注册
	@Override
	public void register(User user) {
		userdao.register(user);
	}

	//登录（按用户名和密码查询）
	@Override
	public User login(User user) {
		return userdao.login(user);
	}

	//查询所有用户
	@Override
	public List<User> queryAll() {
		return userdao.queryAll();
	}

	//修改用户信息
	public void updateUserinfo(User user) {
		userdao.updateUserinfo(user);
	}
	
	//修改密码
	@Override
	public void updatePassword(User user,int userid) {
		userdao.updatePassword(user,userid);
		
	}

	//按用户详细信息查找用户
	@Override
	public User userQueryBydetail(User user) {
		return userdao.userQueryBydetail(user);
	}
	
	//查询所有公告
	@Override
	public List<Announcement> queryAllanno() {
		return userdao.queryAllanno();
	}

	//添加公告
	@Override
	public void addAnnounce(Announcement announcement) {
		userdao.addAnnounce(announcement);
		
	}

	//按id查询公告
	@Override
	public Announcement queryAnnoByid(Announcement announcement) {
		return userdao.queryAnnoByid(announcement);
	}

	@Override
	public void deleteUser(User user) {
		userdao.deleteUser(user);
		
	}
}
