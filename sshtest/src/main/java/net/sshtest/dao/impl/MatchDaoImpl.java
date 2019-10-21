package net.sshtest.dao.impl;

import net.sshtest.dao.IMatchDao;
import net.sshtest.entity.Matchinfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository 
@Transactional
public class MatchDaoImpl implements IMatchDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addMatch(Matchinfo matchinfo) {
		getSession().save(matchinfo);
		
	}

	@Override
	public void updateMatchinfo(Matchinfo matchinfo) {
		getSession().update(matchinfo);
		
	}

	@Override
	public void deleteMatch(Matchinfo matchinfo) {
		
		String hql = "UPDATE Matchinfo m SET m.state = ? WHERE m.matchid = ?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, 1);
		query.setInteger(1, matchinfo.getMatchid());
		query.executeUpdate();
		
	}

	@Override
	public void passMatch(Matchinfo matchinfo) {

		String hql = "UPDATE Matchinfo m SET m.matchState = ? WHERE m.matchid = ?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, 1);
		query.setInteger(1, matchinfo.getMatchid());
		query.executeUpdate();
		
	}
	
	//查询所有
	@Override
	public List<Matchinfo> searchMatch() {
		String hql = "from Matchinfo matchinfo";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	
	//查询赛事通过名称
	@Override
	public List<Matchinfo> searchMatchByname(Matchinfo matchinfo) {
		String hql = "from Matchinfo matchinfo where matchinfo.matchName=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, matchinfo.getMatchName());
		return query.list();
	}
	
	//查询赛事通过userid
	@Override
	public List<Matchinfo> searchMatchByuserid(int userid) {
		String hql = "from Matchinfo matchinfo where matchinfo.userid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, userid);
		return query.list();
	}
	
	
}
