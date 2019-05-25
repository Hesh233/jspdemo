package com.HLXY.controller;

import java.util.List;

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

import com.HLXY.dto.RecruitReqDto;
import com.HLXY.dto.RecruitResp;
import com.HLXY.entity.RecruitType;
import com.HLXY.service.RecruitService;
import com.HLXY.util.JsonResult;
import com.HLXY.util.ResultCode;
import com.alibaba.fastjson.JSONArray;

@Controller
@Scope(value = "prototype")
@RequestMapping("/recruit")
public class RecruitController extends BaseController {
	@Autowired
	private RecruitService recruitService;
	/**
	 * 根据用户类型返回招聘信息页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/recruit_data")
	public String data_page(HttpSession session, Model model) {
		Integer type= (Integer) session.getAttribute("type");
		Integer userId = (Integer) session.getAttribute("userId");
		if(type == null) return "redirect:/user/login";
		session.setAttribute("userId", userId);
			return "recruit/recruitData";
	}
	/**
	 * 	
	 * 招聘类型设置页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/type_set")
	public String type_page(HttpSession session, Model model) {
		Integer type= (Integer) session.getAttribute("type");
		if(type == null) return "redirect:/user/login";
		if(type != 1) return "redirect:/user/login";
			return "recruit/typeSet";
	}
	/**
	 * 添加页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/recruit_add_form")
	public String recruit_add(HttpSession session, Model model) {
		
		Integer type= (Integer) session.getAttribute("type");
		if(type == 1) {
			return "recruit/recruitAddForm";
		}else return "redirect:/user/login";
	}
	/**
	 * 修改页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/recruit_change_form")
	public String recruit_change_form(HttpSession session, Model model
			,@RequestParam("id")Integer id) {
		
		Integer type= (Integer) session.getAttribute("type");
		Integer userId = (Integer) session.getAttribute("userId");
		model.addAttribute("id", id);
		session.setAttribute("userId", userId);
		if(type == 1) {
			return "recruit/recruitChangeForm";
		}else return "redirect:/user/login";
	}
	
	
	/**
	 * 招聘信息页面接口
	 * @param req
	 * @return
	 */
	@ResponseBody
	@GetMapping("recruit_page")
	public JsonResult recruit_page( RecruitReqDto req,
			HttpSession session, Model model) {
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");	
		try {
			if(req.interviewType == 0) {
				req.interviewType = null;
			}
			JSONArray ja = recruitService.recruit_page(req);
			Integer count = recruitService.recruit_page_count(req.interviewType);
			return new JsonResult(ResultCode.SUCCESS, "",count,ja);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 招聘类型接口
	 * @param req
	 * @return
	 */
	@ResponseBody
	@GetMapping("recruit_type")
	public JsonResult recruit_type(RecruitReqDto req,
			HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(!checkSeesionApi(userId)) return new JsonResult(ResultCode.FAIL,"非法请求");		
		try {
			List<RecruitType> rt = recruitService.type_page(req.page,req.limit);
			Integer count = recruitService.type_count();
			return new JsonResult(ResultCode.SUCCESS, "",count,rt);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 查看单条记录
	 * @param req
	 * @param session
	 * @return
	 */
	@ResponseBody
	@PostMapping("one_recruit")
	public JsonResult one_recruit(@RequestBody RecruitReqDto req,
			HttpSession session) {
		Integer studentNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(!checkSeesionApi(studentNum)) return new JsonResult(ResultCode.FAIL,"非法请求");		
		try {
			RecruitResp rt = recruitService.one_recruit(req.id);
			return new JsonResult(ResultCode.SUCCESS, "",rt);
		} catch (Exception e) {
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 添加招聘类型信息
	 */
	@ResponseBody
	@PostMapping("recruit_add_handle")
	public JsonResult recruit_add_handle(@RequestBody RecruitReqDto req,
			HttpSession session) {
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		try {
			String res = recruitService.recruit_add(req);
			return new JsonResult(ResultCode.SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 修改单条招聘类型信息
	 */
	@ResponseBody
	@PostMapping("recruit_change_handle")
	public JsonResult recruit_change_handle(@RequestBody RecruitReqDto req,
			HttpSession session) {
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"),1)) return new JsonResult(ResultCode.FAIL,"非法请求");	
		try {
			String res = recruitService.recruit_change(req);
			return new JsonResult(ResultCode.SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 修改招聘信息
	 */
	@ResponseBody
	@PostMapping("recruit_inf_change")
	public JsonResult recruit_inf_change(@RequestParam("datas")String datas,
			HttpSession session) {
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"),1)) return new JsonResult(ResultCode.FAIL,"非法请求");	
		try {
			JSONArray jsonArray = JSONArray.parseArray(datas);
			String res = recruitService.recruit_inf_change(jsonArray,(Integer) session.getAttribute("userId"));
			return new JsonResult(ResultCode.SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 修改招聘类型信息
	 */
	@ResponseBody
	@PostMapping("recruit_type_change")
	public JsonResult recruit_type_change(@RequestParam("datas")String datas,
			HttpSession session) {
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"),1)) return new JsonResult(ResultCode.FAIL,"非法请求");		
		try {
			JSONArray jsonArray = JSONArray.parseArray(datas);
			String res = recruitService.recruit_type_change(jsonArray,(Integer) session.getAttribute("userId"));
			return new JsonResult(ResultCode.SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 删除招聘信息
	 */
	@ResponseBody
	@PostMapping("recruit_inf_del")
	public JsonResult recruit_inf_del(@RequestParam("datas")String datas,
			HttpSession session) {
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"),1)) return new JsonResult(ResultCode.FAIL,"非法请求");		
		try {
//			JSONArray jsonArray = JSONArray.parseArray(datas);
			String res = recruitService.recruit_inf_del(datas,(Integer) session.getAttribute("userId"));
			return new JsonResult(ResultCode.SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 删除招聘类型信息
	 */
	@ResponseBody
	@PostMapping("recruit_type_del")
	public JsonResult recruit_type_del(@RequestParam("datas")String datas,
			HttpSession session) {
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"),1)) return new JsonResult(ResultCode.FAIL,"非法请求");			
		try {
			String res = recruitService.recruit_type_del(datas,(Integer) session.getAttribute("userId"));
			return new JsonResult(ResultCode.SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
