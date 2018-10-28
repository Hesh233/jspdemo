package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.domain.GoodsInfo;
import com.ssm.service.GoodsService;
import com.ssm.service.UserService;



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
	public String toshowdetail(HttpSession session,HttpServletResponse response,@PathVariable int regex1,Model model) {
		GoodsInfo gn = goodsService.showdetails(regex1);
		//String str = goodsService.switchclass(gn.getGtypeId());
		//System.out.println(goodsService.switchclass(regex1));
		goodsService.addgclick(regex1);
		model.addAttribute( "gtitle",goodsService.switchclass(gn.getGtypeId()));
		model.addAttribute( "goodsinf",gn);
		model.addAttribute( "listn",goodsService.shownew());
		model.addAttribute( "isdetail",1);
		model.addAttribute( "title","浏览详情");
		lasturl(response,"http://localhost:8080/df/goods/"+String.valueOf(regex1), session);		
		return "goods/detail";
	}
	
	
	@RequestMapping("/list{regex1:[1-9]}_{regex2:[1-9]}_{regex3:[1-9]}")
	public String toshowlist(HttpSession session,HttpServletResponse response,@PathVariable int regex1,@PathVariable int regex2,@PathVariable int regex3,Model model) {
		List listg = goodsService.showlist(regex1, regex2, regex3);
		List listn = goodsService.shownew();
		//System.out.println(((GoodsInfo) listg.get(0)).getGtypeId());
		model.addAttribute( "gtitle",goodsService.switchclass(regex1));
		model.addAttribute( "maxpage",goodsService.typepage_count(regex1));
		model.addAttribute( "regex3",regex3);
		model.addAttribute( "page",regex2);
		model.addAttribute( "regex1",regex1);
		model.addAttribute( "listg",listg);
		model.addAttribute( "listn",listn);
		model.addAttribute( "title","类别查看");
		lasturl(response,"http://localhost:8080/df/goods/list"+String.valueOf(regex1)+"_"+String.valueOf(regex2)+"_"+String.valueOf(regex3), session);
		return "goods/list";	
	}
	@RequestMapping("/index")
	public String toindex(HttpSession session,HttpServletResponse response,Model model) {
		model.addAttribute( "listg1",goodsService.showindex(1).get(0));      //1水果2海鲜3肉4蛋5菜6雪糕 
		model.addAttribute( "listn1",goodsService.showindex(1).get(1));      //n:新品 g:点击量高到低
		model.addAttribute( "listg2",goodsService.showindex(2).get(0));
		model.addAttribute( "listn2",goodsService.showindex(2).get(1));
		model.addAttribute( "listg3",goodsService.showindex(3).get(0));
		model.addAttribute( "listn3",goodsService.showindex(3).get(1));
		model.addAttribute( "listg4",goodsService.showindex(4).get(0));
		model.addAttribute( "listn4",goodsService.showindex(4).get(1));
		model.addAttribute( "listg5",goodsService.showindex(5).get(0));
		model.addAttribute( "listn5",goodsService.showindex(5).get(1));
		model.addAttribute( "listg6",goodsService.showindex(6).get(0));
		model.addAttribute( "listn6",goodsService.showindex(6).get(1));
		model.addAttribute( "title","首页");
		lasturl(response,"http://localhost:8080/df/goods/index", session);
		return "goods/index";
		
	}
	@RequestMapping("/search{regex1:[1-9]}_{key:\\S+}")
	public String tosearch(HttpSession session,HttpServletResponse response,Model model,@PathVariable int regex1,@PathVariable String key) {
		System.out.println(key);
		if (goodsService.showsearch(key,regex1)!=null) {
		List listg = goodsService.showsearch(key,regex1);		
		model.addAttribute( "maxpage",goodsService.showmaxsearch_page(key));
		model.addAttribute( "listg",listg);
		}
		List listn = goodsService.shownew();
		model.addAttribute( "title","搜索");
		model.addAttribute( "listn",listn);
		model.addAttribute( "gtitle","搜索");
		lasturl(response,"http://localhost:8080/df/goods/search"+String.valueOf(regex1)+"_"+key,session);
		return "goods/list";
	}
	public void lasturl(HttpServletResponse response,String url,HttpSession session)
	{
		session.setAttribute("lasturl", url);
		System.out.println(url);
	}
}
