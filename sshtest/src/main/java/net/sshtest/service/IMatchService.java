package net.sshtest.service;

import net.sshtest.entity.Matchinfo;

import java.util.List;

public interface IMatchService {
	
	public List<Matchinfo> searchMatchByuserid(int userid);
	
	public List<Matchinfo> searchMatchByname(Matchinfo matchinfo);

	public List<Matchinfo> searchMatch();
	
	//添加赛事
	public void addMatch(Matchinfo matchinfo);
	
	//修改赛事
	public void updateMatch(Matchinfo matchinfo);
	
	//删除赛事
	public void deleteMatch(Matchinfo matchinfo);
	
	//通过赛事
	public void passMatch(Matchinfo matchinfo);

}
