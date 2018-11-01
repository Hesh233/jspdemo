package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.service.CartService;
import com.ssm.util.CsrfToken;
import com.ssm.domain.CartInfo;

@Controller
@Scope(value = "prototype")
@RequestMapping({ "/", "/cart" })
public class CartController {
	@Resource
	private CartService cartService;

	@RequestMapping("/tocart")
	public String tocart(HttpServletResponse response, HttpSession session, HttpServletRequest request, Model model) {
		model.addAttribute("title", "购物车");
		String csrf = CsrfToken.getCsrfToken();
		session.setAttribute("csrf_token", csrf);
		if (session.getAttribute("id") == null) {
			model.addAttribute("error_login", "2");// 未登录先登录
			lasturl(response, "http://localhost:8080/df/cart/tocart", session);
			return "redirect:/user/login";// 重定向接不了attribute
		}
		int id = (int) session.getAttribute("id");
		List cartlist = cartService.getcart(id);
		List countlist = cartService.getcount(id);// dao加个泛型试试
		// System.out.println(((CartInfo)
		// countlist.get(0)).getCount());//报错:mapper返回值内容要研究研究
		model.addAttribute("cartcount", countlist);
		model.addAttribute("cartlist", cartlist);
		lasturl(response, "http://localhost:8080/df/cart/tocart", session);
		return "cart/cart";
	}

	@RequestMapping("/edit{goodsid:\\d+}_{num:\\d+}")
	@ResponseBody
	public String edit(HttpSession session, Model model, @PathVariable int goodsid, @PathVariable int num) {
		if (session.getAttribute("id") == null) {
			model.addAttribute("error_login", "2");// 未登录先登录
			return "redirect:/user/login";// 重定向接不了attribute
		}
		int id = (int) session.getAttribute("id");
		cartService.editcount(id, goodsid, num);
		return "0";
	}

	@RequestMapping("/delete{goodsid:\\d+}")
	@ResponseBody
	public String deletecart(HttpSession session, Model model, @PathVariable int goodsid) {
		if (session.getAttribute("id") == null) {
			model.addAttribute("error_login", "2");// 未登录先登录
			return "redirect:/user/login";// 重定向接不了attribute
		}
		int id = (int) session.getAttribute("id");
		cartService.delectcart(id, goodsid);
		return "0";
	}

	@RequestMapping("/add")

	public @ResponseBody Map<String, Object> add(HttpSession session, HttpServletRequest request, Model model) {
//		if (session.getAttribute("id") == null) {
//			model.addAttribute("error_login", "2");// 未登录先登录
//			return "redirect:/user/login";//重定向接不了attribute
//		}	
		int count = 0;
		int goodsid = 0;
		int num = 0;
		// System.out.println(request.getParameter("a"));System.out.println(request.getParameter("b"));
		Map<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("id") != null) {
			int id = (int) session.getAttribute("id");
			goodsid = Integer.parseInt(request.getParameter("a"));
			count = Integer.parseInt(request.getParameter("b"));
			num = cartService.addcart(id, goodsid, count);
		} else {
		}
		map.put("count", num);
		// System.out.println(num);
		return map;
	}

	@RequestMapping("/getnum")
	@ResponseBody
	public String getnum(HttpSession session, HttpServletRequest request, Model model) {
		int num = 0;
		if (session.getAttribute("id") != null) {
			int id = (int) session.getAttribute("id");
			num = cartService.getnum(id);
		}
		String Str = String.valueOf(num);
		return Str;
	}

	public void lasturl(HttpServletResponse response, String url, HttpSession session) {
		Cookie cookie = new Cookie("lasturl", url);
		cookie.setPath("/");
		response.addCookie(cookie);
		// session.setAttribute("lasturl", url);
		System.out.println(url);
	}
}
