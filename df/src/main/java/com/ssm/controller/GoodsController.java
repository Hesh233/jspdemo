package com.ssm.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssm.domain.GoodsInfo;
import com.ssm.service.GoodsService;
import com.ssm.util.CsrfToken;

@Controller
@Scope(value = "prototype")
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private GoodsService goodsService;

//	@RequestMapping("/{regex1:[1-9]}_{regex2:[1-9]}_{regex3:[1-9]")
//	public String showpath(@PathVariable String regex1, 
//	    @PathVariable String regex2,@PathVariable String regex3,Model model) {
//	    Map<String, Object> result = new HashMap<>();
//	    result.put("regex1", regex1);
//	    result.put("regex2", regex2);
//	    return "";
//	}
	@RequestMapping("/{regex1:\\d+}")
	public String toshowdetail(HttpSession session, HttpServletResponse response, @PathVariable int regex1, Model model,
			@CookieValue(value = "review", required = false) String review) {
		model.addAttribute("title", "浏览详情");
		String csrf = CsrfToken.getCsrfToken();
		session.setAttribute("csrf_token", csrf);
		try {
			List l = new ArrayList();
			boolean isskip = false;
			if (review != null) {
				String[] nums = review.split("#");
				for (int i = 0; i < nums.length; i++) {
					if (nums.length == 4) {
						if ((nums[i].equals(String.valueOf(regex1)))) {
							isskip = true;
						} else if (i == 3 && !isskip) {

						} else {
							l.add(nums[i]);
							System.out.println("i=4加入i" + nums[i]);
						}
					} else if (!(nums[i].equals(String.valueOf(regex1))) && nums.length < 4) {
						l.add(nums[i]);
						System.out.println("i<4加入i" + nums[i]);
					}
				}
				l.add(String.valueOf(regex1));
				System.out.println("加入" + String.valueOf(regex1));
				String str = String.join("#", l);
				System.out.println(str);
				Cookie cookie = new Cookie("review", str);
				cookie.setPath("/");
				response.addCookie(cookie);
				// model.addAttribute("viewg", l);
			} else {
				System.out.println("review为空");
				String str = String.valueOf(regex1);
				Cookie cookie = new Cookie("review", str);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		} catch (Exception e) {
			System.out.println("cookie设置错误" + e);
			return "goods/detail";
		}

		GoodsInfo gn = goodsService.showdetails(regex1);
		// String str = goodsService.switchclass(gn.getGtypeId());
		// System.out.println(goodsService.switchclass(regex1));
		goodsService.addgclick(regex1);
		model.addAttribute("gtitle", goodsService.switchclass(gn.getGtypeId()));
		model.addAttribute("goodsinf", gn);
		model.addAttribute("listn", goodsService.shownew());
		model.addAttribute("isdetail", 1);
		lasturl(response, "http://localhost:8080/df/goods/" + String.valueOf(regex1), session);
		return "goods/detail";
	}

	@RequestMapping("/list{regex1:[1-9]}_{regex2:[1-9]}_{regex3:[1-9]}")
	public String toshowlist(HttpSession session, HttpServletResponse response, @PathVariable int regex1,
			@PathVariable int regex2, @PathVariable int regex3, Model model) {
		String csrf = CsrfToken.getCsrfToken();
		session.setAttribute("csrf_token", csrf);
		model.addAttribute("title", "类别查看");
		List listg = goodsService.showlist(regex1, regex2, regex3);
		List listn = goodsService.shownew();
		// System.out.println(((GoodsInfo) listg.get(0)).getGtypeId());
		model.addAttribute("gtitle", goodsService.switchclass(regex1));
		model.addAttribute("maxpage", goodsService.typepage_count(regex1));
		model.addAttribute("regex3", regex3);
		model.addAttribute("page", regex2);
		model.addAttribute("regex1", regex1);
		model.addAttribute("listg", listg);
		model.addAttribute("listn", listn);
		lasturl(response, "http://localhost:8080/df/goods/list" + String.valueOf(regex1) + "_" + String.valueOf(regex2)
				+ "_" + String.valueOf(regex3), session);
		return "goods/list";
	}

	@RequestMapping("/index")
	public String toindex(HttpSession session, HttpServletResponse response, Model model) {
		String csrf = CsrfToken.getCsrfToken();
		session.setAttribute("csrf_token", csrf);
		model.addAttribute("listg1", goodsService.showindex(1).get(0)); // 1水果2海鲜3肉4蛋5菜6雪糕
		model.addAttribute("listn1", goodsService.showindex(1).get(1)); // n:新品 g:点击量高到低
		model.addAttribute("listg2", goodsService.showindex(2).get(0));
		model.addAttribute("listn2", goodsService.showindex(2).get(1));
		model.addAttribute("listg3", goodsService.showindex(3).get(0));
		model.addAttribute("listn3", goodsService.showindex(3).get(1));
		model.addAttribute("listg4", goodsService.showindex(4).get(0));
		model.addAttribute("listn4", goodsService.showindex(4).get(1));
		model.addAttribute("listg5", goodsService.showindex(5).get(0));
		model.addAttribute("listn5", goodsService.showindex(5).get(1));
		model.addAttribute("listg6", goodsService.showindex(6).get(0));
		model.addAttribute("listn6", goodsService.showindex(6).get(1));
		model.addAttribute("title", "首页");
		lasturl(response, "http://localhost:8080/df/goods/index", session);
		return "goods/index";

	}

	@RequestMapping("/search{regex1:[1-9]}_{key:\\S+}")
	public String tosearch(HttpSession session, HttpServletResponse response, Model model, @PathVariable int regex1,
			@PathVariable String key) {
		model.addAttribute("title", "搜索");
		String csrf = CsrfToken.getCsrfToken();
		session.setAttribute("csrf_token", csrf);
		System.out.println(key);
		if (goodsService.showsearch(key, regex1) != null) {
			List listg = goodsService.showsearch(key, regex1);
			model.addAttribute("maxpage", goodsService.showmaxsearch_page(key));
			model.addAttribute("listg", listg);
		}
		List listn = goodsService.shownew();
		model.addAttribute("listn", listn);
		model.addAttribute("gtitle", "搜索");
		lasturl(response, "http://localhost:8080/df/goods/search" + String.valueOf(regex1) + "_" + key, session);
		return "goods/list";
	}

	public void lasturl(HttpServletResponse response, String url, HttpSession session) {
		Cookie cookie = new Cookie("lasturl", url);
		cookie.setPath("/");
		response.addCookie(cookie);
		// session.setAttribute("lasturl", url);
		System.out.println(url);
	}

}
