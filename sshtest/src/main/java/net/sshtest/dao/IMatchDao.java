package net.sshtest.dao;

import net.sshtest.entity.Matchinfo;

import java.util.List;


public interface IMatchDao {

	//添加赛事
	public void addMatch(Matchinfo matchinfo);
	
	//修改赛事信息
	public void updateMatchinfo(Matchinfo matchinfo);
	
	//删除赛事
	public void deleteMatch(Matchinfo matchinfo);
	
	//审核通过赛事
	public void passMatch(Matchinfo matchinfo);
	
	//查询所有赛事
	public List<Matchinfo> searchMatch();

	//通过赛事名称查询赛事
	public List<Matchinfo> searchMatchByname(Matchinfo matchinfo);

	//通过用户id查询赛事
	public List<Matchinfo> searchMatchByuserid(int userid);
}
