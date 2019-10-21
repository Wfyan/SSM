package net.sshtest.dao.impl;

import net.sshtest.dao.IUserDao;
import net.sshtest.entity.Announcement;
import net.sshtest.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository 
@Transactional
public class UserDaoImpl implements IUserDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	//注册
	public void register(User user) {
		getSession().save(user);
	}

	//登录（按用户名和密码查询）
	@Override
	public User login(User user) {
		
		String username = user.getUsername();
		String password = user.getPassword();
		String hql = "FROM User user WHERE user.username = ? AND user.password = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, username);
		query.setString(1, password);
		User user1 = (User)query.uniqueResult();
		return user1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAll() {

		String hql = "From User user";
		return getSession().createQuery(hql).list();
	}

	@Override
	public void updatePassword(User user,int userid) {
		
		String password = user.getPasswordnew();
		String hql = "UPDATE User user SET user.password = ? WHERE user.userid = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0,password);
		query.setInteger(1, userid);
		query.executeUpdate();
		
	}

	//通过用户详细信息查找用户
	@Override
	public User userQueryBydetail(User user) {
		
		String username =  user.getUsername();
		String phoneNumber = user.getPhoneNumber();
		String hql = "From User user WHERE user.username = ? AND user.phoneNumber = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, username);
		query.setString(2, phoneNumber);
		User user1 = (User) query.uniqueResult();
		return user1;
	}

	//按照用户名查询用户
	public User userQueryByname(User user) {
		
		String hql = "From User user WHERE user.username = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, user.getUsername());
		User user1 = (User) query.uniqueResult();
		return user1;
	}
	
	//查找所有公告
	@SuppressWarnings("unchecked")
	@Override
	public List<Announcement> queryAllanno() {

		String hql = "FROM Announcement";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	//添加公告
	@Override
	public void addAnnounce(Announcement announcement) {
		
		getSession().saveOrUpdate(announcement);
		
	}

	//按id查询公告
	@Override
	public Announcement queryAnnoByid(Announcement announcement) {
		
		String hql = "From Announcement anno WHERE anno.announcementTitle = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, announcement.getAnnouncementTitle());
		Announcement announce = (Announcement) query.uniqueResult();
		return announce;
	}

	@Override
	public void deleteUser(User user) {

		String hql = "Update User user SET user.state = ? WHERE user.userid = ?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, 1);
		query.setInteger(1, user.getUserid());
		query.executeUpdate();
		
	}

	@Override
	public void updateUserinfo(User user) {
		getSession().update(user);
	}

}
