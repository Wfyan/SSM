package net.sshtest.controller;

import net.sshtest.entity.Matchinfo;
import net.sshtest.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/match")
public class MatchController {

	@Autowired
	private IMatchService matchservice;
	Map<String,Object> map = new HashMap<String,Object>();

	public IMatchService getMatchservice() {
		return matchservice;
	}

	public void setMatchservice(IMatchService matchservice) {
		this.matchservice = matchservice;
	}
	
	/**
	 * 查询所有赛事
	 * @return
	 */
	@RequestMapping("searchMatch")
	@ResponseBody
	public Map<String,Object> searchMatch(){
	
		if(matchservice.searchMatch()!=null) {
			map.put("matchlist",matchservice.searchMatch());
			map.put("status", 1);
		}else {
			map.put("error", "error");
			map.put("status", 0);
		}
		return map;
	}
	
	/**
	 * 按名查询赛事
	 * @param matchName
	 * @return
	 */
	@RequestMapping("searchMatchByname")
	@ResponseBody
	public Map<String,Object> searchMatchByname(String matchName){
		Matchinfo matchinfo = new Matchinfo();
		matchinfo.setMatchName(matchName);
		if(matchservice.searchMatchByname(matchinfo)!=null) {
			map.put("matchlist",matchservice.searchMatchByname(matchinfo));
			map.put("status", 1);
		}else {
			map.put("error", "error");
			map.put("status", 0);
		}
		return map;
	} 
	
	/**
	 * 按id查询赛事
	 * @param userid
	 * @return
	 */
	@RequestMapping("searchMatchByuserid")
	@ResponseBody
	public Map<String,Object> searchMatchByuserid(int userid){
		if(matchservice.searchMatchByuserid(userid)!=null) {
			map.put("matchlist",matchservice.searchMatchByuserid(userid));
			map.put("status", 1);
		}else {
			map.put("error", "error");
			map.put("status", 0);
		}
		return map;
	}
	
	/**
	 * 添加赛事
	 * @param matchinfo
	 */
	@RequestMapping("addmatch")
	@ResponseBody
	public void addMatch(Matchinfo matchinfo) {
		matchservice.addMatch(matchinfo);
	}
	
	/**
	 * 修改赛事
	 * @param matchinfo
	 */
	@RequestMapping("updatematch")
	@ResponseBody
	public void updateMatch(Matchinfo matchinfo) {
		matchservice.updateMatch(matchinfo);
	}
	
	/**
	 * 删除赛事
	 * @param matchid
	 */
	@RequestMapping("deletematch")
	@ResponseBody
	public void deleteMatch(int matchid) {
		Matchinfo matchinfo = new Matchinfo();
		matchinfo.setMatchid(matchid);
		matchservice.deleteMatch(matchinfo);
	}
	
	/**
	 * 审核通过赛事
	 * @param matchid
	 */
	@RequestMapping("passmatch")
	@ResponseBody
	public void passMatch(int matchid) {
		Matchinfo matchinfo = new Matchinfo();
		matchinfo.setMatchid(matchid);
		matchservice.passMatch(matchinfo);
	}
}
