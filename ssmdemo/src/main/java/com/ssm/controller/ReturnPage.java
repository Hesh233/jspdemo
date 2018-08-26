package com.ssm.controller;
//还没开始写，这个类不用管,作用是使后面url跳转符合视图界面
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ssm.domain.User;
import com.ssm.service.UserService;
import com.ssm.utils.myFilter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// 单例模式，自加
@Scope(value = "prototype")
@RequestMapping({ "/", "/user" })
public class ReturnPage {
	@RequestMapping(value="/loginForm")
	public String loginForm(HttpSession session,HttpServletRequest request) throws Exception {
		request.setAttribute("inf", session.getAttribute("inf"));
		session.removeAttribute("inf");
		return "login/login";		
	}	
	@RequestMapping(value="/registerForm")
	public String registerForm() throws Exception {
		return "login/register";		
	}
	@RequestMapping(value="/shopInfregisterForm")
	public String shopInfregisterForm() throws Exception {
		return "shop/shopInfregister";		
	}
	@RequestMapping(value="/welcome")
	public String welcome() throws Exception {
		return "shop/index";		
	}
	@RequestMapping(value="shopInf/menusetting")
	public String menusetting() throws Exception {
		return "shop/menusetting";		
	}
	@RequestMapping(value="/customerindex")
	public String customerindex() throws Exception {
		return "customer/index";		
	}
	@RequestMapping(value="shopInf/menuset")
	public String menuset() throws Exception {
		return "shop/menuset";		
	}
	@RequestMapping(value="/fail")
	public String fail() throws Exception {
		return "fail";		
	}
	@RequestMapping(value="/shopInfregistersuccess")
	public String shopInfregistersuccess() throws Exception {
		return "shop/shopInfregistersuccess";		
	}
	@RequestMapping(value="/shopindex")
	public String shopindex() throws Exception {
		return "shop/index";		
	}
	@RequestMapping(value="/index")
	public String index() throws Exception {
		return "shop/main";		
	}
	
	
	@RequestMapping(value="/bottom")
	public String main() throws Exception {
		return "shop/bottom";}
		@RequestMapping(value="/left")
		public String left() throws Exception {
			return "shop/menu";	}
		@RequestMapping(value="/top")
		public String top() throws Exception {
			return "shop/top";	}
}
