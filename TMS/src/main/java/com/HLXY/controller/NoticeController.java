package com.HLXY.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HLXY.dto.NoticeReqDto;
import com.HLXY.service.NoticeService;
import com.HLXY.util.JsonResult;
import com.HLXY.util.ResultCode;
import com.HLXY.util.ServerException;
import com.alibaba.fastjson.JSONArray;
@Controller
@Scope(value = "prototype")
@RequestMapping("/notice")
public class NoticeController  extends BaseController {
	@Autowired
	private NoticeService noticeService;
	/**
	 * 根据用户类型返回通知信息页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/notice_data")
	public String data_page(HttpSession session, Model model) {
		Integer type= (Integer) session.getAttribute("type");
		if(type == null) return "redirect:/user/login";
		if(type == 0) {
			return "notice/noticeForm";
		}{
			return "notice/noticeData";
		}
	}

	/**
	 * 根据用户类型返回通知子页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/notice_one_data")
	public String notice_one_data(HttpSession session, Model model
			,@RequestParam(name="id",required=false)Integer id,@RequestParam(name="change",required=false)Integer change ) {
		model.addAttribute("id",id);
		//区分修改
		model.addAttribute("change",change);
		Integer type= (Integer) session.getAttribute("type");	
		if(type == 0 || type == 1) {
			return "notice/noticeInf";
		}
		else return "redirect:/user/login";	
	}
	/**
	 * 老师/学生查看列表
	 */
	@ResponseBody
	@GetMapping("notice_page")
	public JsonResult notice_page(NoticeReqDto req, HttpSession session, HttpServletRequest request, Model model) {	
		req.teacherNum = (Integer) session.getAttribute("userId");
		req.studentNum = (Integer) session.getAttribute("userId");
		req.sessType =(Integer) session.getAttribute("type");
		if(!checkSeesionApi(req.teacherNum)) return new JsonResult(ResultCode.FAIL,"非法请求");	
		try {
			JSONArray res = noticeService.notice_page(req);
			return new JsonResult(ResultCode.SUCCESS, "",noticeService.notice_page_count(req),res);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 老师\学生查看单条记录
	 */
	@ResponseBody
	@GetMapping("select_one")
	public JsonResult select_one(NoticeReqDto req, HttpSession session, HttpServletRequest request, Model model) {	
		req.sessType =(Integer) session.getAttribute("type");
		req.teacherNum =(Integer) session.getAttribute("type");
		if(!checkSeesionApi(req.teacherNum)) return new JsonResult(ResultCode.FAIL,"非法请求");	
		try {
			Map<String,Object> map = noticeService.select_one(req.sessType, req.id, (Integer) session.getAttribute("userId"));  
			return new JsonResult(ResultCode.SUCCESS, "",map);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 老师新增\修改单条记录
	 */
	@ResponseBody
	@PostMapping("notice_inf_change")
	public JsonResult notice_inf_change(@RequestBody NoticeReqDto req
			, HttpSession session, HttpServletRequest request, Model model) {	
		req.sessType = (Integer) session.getAttribute("type");
		req.teacherNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi(req.teacherNum)) return new JsonResult(ResultCode.FAIL,"非法请求");	
		if(checkType((Integer) session.getAttribute("type"),1)) return new JsonResult(ResultCode.FAIL,"非法请求");
		try {
			String res = noticeService.notice_inf_change(req, (Integer) session.getAttribute("userId"));  
			return new JsonResult(ResultCode.SUCCESS, "",noticeService.notice_page_count(req),res);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 删除通知信息
	 */
	@ResponseBody
	@PostMapping("notice_inf_del")
	public JsonResult notice_inf_del(@RequestParam("datas")String datas,
			HttpSession session) {
		Integer type = (Integer) session.getAttribute("type");
		Integer teaNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi(teaNum)) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"),1)) return new JsonResult(ResultCode.FAIL,"非法请求");		
		try {
			String res ;
			if(type == 1) {
				 res = noticeService.notice_inf_del(datas, teaNum);
			}else throw new ServerException("非法请求");
			return new JsonResult(ResultCode.SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
