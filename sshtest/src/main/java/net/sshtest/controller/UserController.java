package net.sshtest.controller;

import net.sshtest.entity.Announcement;
import net.sshtest.entity.User;
import net.sshtest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userservice;
	Map<String,Object> map = new HashMap<String,Object>();
	
	public IUserService getUserservice() {
		return userservice;
	}

	public void setUserservice(IUserService userservice) {
		this.userservice = userservice;
	}

	
	/**
	 * 注册
	 * @param user
	 */
	@RequestMapping(value="register",method = RequestMethod.POST)
	public void register(@RequestBody  User user){
		System.out.println("aaaaaaaa"+user.getUsername());
		userservice.register(user);
	}
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="login")
	@ResponseBody
	public Map<String,Object> login(String username,String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(userservice.login(user) != null) {
			map.put("users", userservice.login(user));
			map.put("status", 1);
		}else {
			map.clear();
			map.put("error","error");
			map.put("status", 0);
		}
		return map;
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	@RequestMapping(value="queryall")
	@ResponseBody
	public Map<String,Object> queryAll() {
		if(userservice.queryAll() != null) {
			map.put("user", userservice.queryAll());
			map.put("status", 1);
		}else {
			map.put("error","error");
			map.put("status", 0);
		}
		return map;
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	@RequestMapping(value="updateuserinfo")
	@ResponseBody
	public void updateUserinfo(User user) {
		userservice.updateUserinfo(user);
	}
	
	/**
	 * 修改用户密码
	 * @param username
	 * @param password
	 * @param passwordnew
	 * @param passwordagain
	 */
	@RequestMapping(value="updatepassword",method = RequestMethod.GET)
	@ResponseBody
	public void updatePassword(@RequestParam("username") String username, @RequestParam("password") String password,
							   @RequestParam("pass")String passwordnew, @RequestParam("checkPass") String passwordagain, HttpServletResponse response){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPasswordnew(passwordnew);
		user.setPasswordagain(passwordagain);
		userservice.updatePassword(user,userservice.login(user).getUserid());
		String result = "{\"result\":1}";
		response.setContentType("application/json");
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 按详细信息查询，查询不为空之后用上面修改密码的方法来重置密码
	 * @param username
	 * @param phoneNumber
	 * @return
	 */
	@RequestMapping(value="userquerybydetail")
	@ResponseBody
	public Map<String,Object> userQueryBydetail(String username,String phoneNumber){
		User user = new User();
		user.setUsername(username);
		user.setPhoneNumber(phoneNumber);
		if(userservice.userQueryBydetail(user) != null) {
			map.put("userid", userservice.userQueryBydetail(user).getUserid());
			map.put("status", 1);
		}else
			map.put("error", "error");
			map.put("status", 0);
		return map;
	}
	
	/**
	 * 查询所有公告
	 * @return
	 */
	@RequestMapping(value="queryallanno")
	@ResponseBody
	public Map<String,Object> queryAllanno(){
		if(userservice.queryAllanno() != null) {
			map.put("announcement",userservice.queryAllanno());
			map.put("status", 1);
		}else
			map.put("error","error");
			map.put("status", 0);
		return map;
	}
	
	/**
	 * 添加公告
	 * @param announcement
	 */
	@RequestMapping(value="addannounce")
	@ResponseBody
	public void addAnnounce(Announcement announcement){
		userservice.addAnnounce(announcement);
	}
	
	/**
	 * 按公告id查询公告
	 * @param announcementid
	 * @return
	 */
	@RequestMapping(value="queryannobytitle")
	@ResponseBody
	public Map<String,Object> queryAnnoByid(int announcementid){
		Announcement announcement = new Announcement();
		announcement.setAnnouncementid(announcementid);
		if(userservice.queryAnnoByid(announcement) != null) {
			map.put("announcement",userservice.queryAnnoByid(announcement));
			map.put("status", 1);
		}else
			map.put("error","error");
			map.put("status", 0);
		return map;
	}
	
	/**
	 * 修改用户状态（删除用户）
	 * @param userid
	 */
	@RequestMapping(value="deleteuser")
	public void deleteUser(int userid) {
		User user = new User();
		user.setUserid(userid);
		userservice.deleteUser(user);
	}
}
