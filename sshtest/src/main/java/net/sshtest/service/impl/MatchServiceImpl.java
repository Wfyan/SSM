package net.sshtest.service.impl;

import net.sshtest.dao.IMatchDao;
import net.sshtest.entity.Matchinfo;
import net.sshtest.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements IMatchService {
	@Autowired
	private IMatchDao matchdao;

	public IMatchDao getMatchdao() {
		return matchdao;
	}

	public void setMatchdao(IMatchDao matchdao) {
		this.matchdao = matchdao;
	}

	@Override
	public List<Matchinfo> searchMatchByuserid(int userid) {
		return matchdao.searchMatchByuserid(userid);
	}

	@Override
	public List<Matchinfo> searchMatchByname(Matchinfo matchinfo) {
		return matchdao.searchMatchByname(matchinfo);
	}

	@Override
	public List<Matchinfo> searchMatch() {
		return matchdao.searchMatch();
	}

	@Override
	public void addMatch(Matchinfo matchinfo) {
		
		matchdao.addMatch(matchinfo);
	}

	@Override
	public void updateMatch(Matchinfo matchinfo) {

		matchdao.updateMatchinfo(matchinfo);
	}

	@Override
	public void deleteMatch(Matchinfo matchinfo) {
		matchdao.deleteMatch(matchinfo);
	}

	@Override
	public void passMatch(Matchinfo matchinfo) {
		matchdao.passMatch(matchinfo);
		
	}
}
