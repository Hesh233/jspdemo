package com.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.domain.UserInfo;
import com.ssm.service.UserService;
//import com.ssm.service.UserService1;


@Controller
@Scope(value = "prototype")
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request,Model model){
		return "user/login";
	}
	@RequestMapping("/login")
	public String tologin(HttpServletRequest request,Model model,@CookieValue(value = "loginCookieUserName",required=false) String loginCookieUserName){
		model.addAttribute( "title","登录");
	//	System.out.println(loginCookieUserName);      
		if(loginCookieUserName!=null) {
			model.addAttribute( "uname",loginCookieUserName);
		}
		return "user/login";
	}
	@RequestMapping("/user_center_info")
	public String toinfo(HttpServletResponse response,HttpSession session,HttpServletRequest request,Model model){
		if(session.getAttribute("id")==null) {
			model.addAttribute( "error_login","2");//未登录先登录
			lasturl(response,"http://localhost:8080/df/user/user_center_info", session);
			return "user/login";
		}
		model.addAttribute( "title","个人信息");
		UserInfo user = userService.getUserById((int) session.getAttribute("id"));
		if(user.getUphone()!=null) {
			String uphone = user.getUphone();
			uphone = uphone.substring(0, 3) + "****" + uphone.substring(7, uphone.length());
			model.addAttribute( "uname",user.getUname());
			model.addAttribute( "Uphone",uphone);
			model.addAttribute( "Uaddress",user.getUaddress());
		}

		return "user/user_center_info";
	}
	@RequestMapping("/user_center_order")
	public String toorder(HttpServletResponse response,HttpSession session,HttpServletRequest request,Model model){
		if(session.getAttribute("id")==null) {
			model.addAttribute( "error_login","2");//未登录先登录
					lasturl(response,"http://localhost:8080/df/user/user_center_order", session);
			return "user/login";
		}
		model.addAttribute( "title","全部订单");

		return "user/user_center_order";
	}
	@RequestMapping("/user_center_site")
	public String toside(HttpServletResponse response,HttpSession session,HttpServletRequest request,Model model){
				if(session.getAttribute("id")==null) {
			model.addAttribute( "error_login","2");//未登录先登录
			lasturl(response,"http://localhost:8080/df/user/user_center_site", session);
			return "user/login";
		}
		UserInfo user = userService.getUserById((int) session.getAttribute("id"));
		if(user.getUphone()!=null) {
			String uphone = user.getUphone();
			uphone = uphone.substring(0, 3) + "****" + uphone.substring(7, uphone.length());
			model.addAttribute( "uname",user.getUname());
			model.addAttribute( "uphone",uphone);
			model.addAttribute( "uaddress",user.getUaddress());
		}
		model.addAttribute( "title","收货地址");
//		if(user.getUphone()!=null) {
//			String uphone = user.getUphone();
//			uphone = uphone.substring(0, 3) + "****" + uphone.substring(7, uphone.length());
//			model.addAttribute( "uname",user.getUshou());
//			model.addAttribute( "Uphone",uphone);
//			model.addAttribute( "Uaddress",user.getUaddress());
//		}
		return "user/user_center_site";
	}
	@RequestMapping("/quitlogin")
	public String quitlogin(HttpSession session,Model model) {
		session.invalidate();
		model.addAttribute( "title","登录");
		return "redirect:login";}
	@RequestMapping("/register")
	public String toregister(HttpServletRequest request,Model model){
		model.addAttribute( "title","注册");
//		int userId = Integer.parseInt(request.getParameter("id"));
//		User user = this.userService.getUserById(userId);
//		model.addAttribute("user", user);
		model.addAttribute( "error_login","");
		return "user/register";
	}

	@RequestMapping("/login_handle")
	public String login_handle(HttpServletResponse response,HttpSession session,UserInfo user,@RequestParam(value="checkbox",required=false) String checkbox, HttpServletRequest request, Model model, ModelAndView mv) {//@CookieValue(value = "lasturl",required=false)String lasturl,		

		//System.out.println(checkbox);
		UserInfo user_handle = userService.Login_handle(user.getUname(), user.getUpwd());
		if (user_handle != null) {//2先登录3用户名或密码错误
			session.setAttribute("username",user.getUname());
			session.setAttribute("id", user_handle.getId());
			if(checkbox!=null && checkbox.equals("on")) {
				//System.out.println(checkbox);
				Cookie cookie = new Cookie("loginCookieUserName",user.getUname());//记住用户名
				response.addCookie(cookie);
			}else {
				Cookie cookie=new Cookie("loginCookieUserName",null);
				response.addCookie(cookie);
			}
			String lasturl = (String) session.getAttribute("lasturl");
			if(lasturl==null) {
				lasturl="http://localhost:8080/df/user/user_center_info";
			}
			session.removeAttribute("lasturl");//session可以用@SessionAttributes(value = {"val1","val2"})注解的，习惯没用了
			return "redirect:"+lasturl;
		} else {
			model.addAttribute( "error_login","3");
			return "user/login";
		}
	}
	
	@RequestMapping("/isregistername_check")
	public @ResponseBody Map<String,Object> registername_check(@RequestParam("uname") String uname,HttpSession session,UserInfo user, HttpServletRequest request, Model model, ModelAndView mv,HttpServletResponse response) {		
		 Map<String,Object> map = new HashMap<String,Object>(); 
		if(userService.isregistername_check(uname)) {
			map.put("count","1"); 
		}else {map.put("count","0"); }
		return map;
	}
	@RequestMapping("/register_handle")
	public String register_handle(UserInfo user,Model model,@RequestParam("cpwd") String cpwd,@RequestParam("allow") String allow) {		

		String user_handle = userService.Register_handle(user,cpwd,allow);
		if (user_handle == null) {//2先登录3用户名或密码错误4注册成功
			model.addAttribute( "error_login","4");
			model.addAttribute( "title","登录");			
			return "user/login";
		} else {
			model.addAttribute( "error_login",user_handle);
		//	System.out.println(user_handle);
			model.addAttribute( "title","注册");
			return "user/register";
		}
	}

	@RequestMapping("/user_center_site_handle")
	public String site_handle(HttpSession session, UserInfo user, Model model) {
		if (session.getAttribute("id") == null) {
			model.addAttribute("error_login", "2");// 未登录先登录
			return "user/login";
		}
		user.setId((Integer) session.getAttribute("id"));
		//System.out.println(user.getUaddress());
		userService.site_handle(user);
		return "redirect:user_center_site";
	}
	public void lasturl(HttpServletResponse response,String url,HttpSession session)
	{
		session.setAttribute("lasturl", url);
		System.out.println(url);
		System.out.println(url);
	}
	

}
