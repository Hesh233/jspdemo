package com.ssm.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.domain.CartInfo;
import com.ssm.domain.UserInfo;
import com.ssm.service.CartService;
import com.ssm.service.GoodsService;
import com.ssm.service.UserService;
import com.ssm.util.CsrfToken;

@Controller
@Scope(value = "prototype")
@RequestMapping("/order")
public class OrderController {
	@Resource
	private CartService cartService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private UserService userService;

	@RequestMapping("/toorder")
	public String toorder(HttpSession session, Model model, HttpServletResponse response) {
		String csrf = CsrfToken.getCsrfToken();
		session.setAttribute("csrf_token", csrf);
		model.addAttribute("title", "提交订单");
		if (session.getAttribute("id") == null) {
			model.addAttribute("error_login", "2");// 未登录先登录
			lasturl(response, "http://localhost:8080/df/order/toorder");
			return "redirect:/user/login";
		}
		UserInfo user = userService.getUserById((int) session.getAttribute("id"));
		if (user.getUphone() != null && user.getUname() != null && user.getUaddress() != null
				&& user.getUshou() != null) {
			String uphone = user.getUphone();
			uphone = uphone.substring(0, 3) + "****" + uphone.substring(7, uphone.length());
			model.addAttribute("Uphone", uphone);
			model.addAttribute("Uaddress", user.getUaddress());
			model.addAttribute("Ushou", user.getUshou());
		} // 获取姓名地址信息
		int id = (int) session.getAttribute("id");// 没有加入任何东西到购物车
		if (cartService.getcart(id) == null) {

			return "order/place_order";
		}
		List<CartInfo> cartlist = cartService.getorder(id);
		List goodslist = new ArrayList();
		int count = 0;
		double sum = 0;
		double cou = 0;
		for (CartInfo c : cartlist) {
			count++;
			// System.out.println(c.getGoodsId());
			cou = goodsService.showdetails(c.getGoodsId()).getGprice().doubleValue();// 单一商品件数
			sum += c.getCount() * cou; // 总价格求和
			goodslist.add(goodsService.showdetails(c.getGoodsId()));
		}
		double sums = sum + 10;
		// List goodslist = (List) goodsService.showdetails(id);
		model.addAttribute("sum", sum);
		model.addAttribute("sums", sums);
		model.addAttribute("count", count);
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("cartlist", cartlist);

		return "order/place_order";
	}

	public void lasturl(HttpServletResponse response, String url) {
		Cookie cookie = new Cookie("lasturl", url);
		cookie.setPath("/");
		response.addCookie(cookie);
		// session.setAttribute("lasturl", url);
		System.out.println(url);
	}
}
