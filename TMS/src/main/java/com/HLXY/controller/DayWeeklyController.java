package com.HLXY.controller;

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

import com.HLXY.dto.WeeklyHandleReqDto;
import com.HLXY.entity.Dirary;
import com.HLXY.service.DayWeeklyService;
import com.HLXY.util.JsonResult;
import com.HLXY.util.ResultCode;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@Scope(value = "prototype")
@RequestMapping("/weekly")

public class DayWeeklyController  extends BaseController{
	@Autowired
	private DayWeeklyService dayWeeklyService;
	/**
	 * 根据用户类型返回周记页面 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/weekly_data")
	public String handle_page(HttpSession session, Model model) {
		Integer type= (Integer) session.getAttribute("type");
		if(type == null) return "redirect:/user/login";
		if(type == 0) {
			model.addAttribute("weekly","");
			return "weekly/weeklyForm";
		}else{
			return "weekly/weeklyData";
		}
	}
	/**
	 * 老师指导记录页面
	 */
	@RequestMapping("/guide_form")
	public String guide_form(HttpSession session, Model model
			) {
		Integer type= (Integer) session.getAttribute("type");
		if(type == 1) {
			return "weekly/guideForm";
		}else {
			return "redirect:/user/login";
		}
	}
	/**
	 * 老师指导页面查询
	 * @param session
	 * @param request
	 * @param model
	 * @param reqDto
	 * @return
	 */
	@ResponseBody
	@PostMapping("/one_guide")
	public JsonResult get_one_guide(HttpSession session, HttpServletRequest request, Model model
			,@RequestBody WeeklyHandleReqDto req) {
		req.teacherNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi(req.teacherNum)) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"), 1)) return new JsonResult(ResultCode.FAIL,"非法请求");
		try {
				JSONObject res = dayWeeklyService.one_guide(req);
				return new JsonResult(ResultCode.SUCCESS,"",res);						
		}catch(Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 老师指导提交接口
	 * @param session
	 * @param request
	 * @param model
	 * @param reqDto
	 * @return
	 */
	@ResponseBody
	@PostMapping("/guide_handle")
	public JsonResult guide_handle(HttpSession session, HttpServletRequest request, Model model
			,@RequestBody WeeklyHandleReqDto req) {
		req.teacherNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi(req.teacherNum)) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"), 1)) return new JsonResult(ResultCode.FAIL,"非法请求");
		try {
				String res = dayWeeklyService.guide_handle(req);
				return new JsonResult(ResultCode.SUCCESS,res);
		}catch(Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 老师查询负责班级
	 */
	@ResponseBody
	@PostMapping("/teacher_class")
	public JsonResult teacher_class(HttpSession session, HttpServletRequest request, Model model
			) {
		Integer type= (Integer) session.getAttribute("type");
		Integer teacherNum = (Integer) session.getAttribute("userId");
		try {
			if(type == 1) {
				JSONObject jo = dayWeeklyService.teacher_class(teacherNum);
				return new JsonResult(ResultCode.SUCCESS,"",jo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
		return new JsonResult(ResultCode.FAIL);
	}
	/**
	 * 老师的周记评价页面
	 * @param session
	 * @param model
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/weekly_apprise_form")
	public String weekly_apprise_form(HttpSession session, Model model,
			@RequestParam("id") Integer id,@RequestParam("name") String name) {
		Integer type= (Integer) session.getAttribute("type");
		Integer seTeacherNum = (Integer) session.getAttribute("userId");
		if(type == 1) {
			Dirary dir = dayWeeklyService.teaApprove(id, seTeacherNum);
			name = name +"第"+dir.getWeekNum()+"周的周记";
			model.addAttribute("weekly","");
			model.addAttribute("dir",dir);
			model.addAttribute("name",name);
			return "weekly/weeklyAppriseForm";
		}else {
			return "redirect:/user/login";
		}
	}
	/**
	 * 学生的周记提交接口
	 * @param session
	 * @param request
	 * @param model
	 * @param reqDto
	 * @return
	 */
	@ResponseBody
	@PostMapping("/weekly_handle")
	public JsonResult weekly_handle(HttpSession session, HttpServletRequest request, Model model
			,@RequestBody WeeklyHandleReqDto reqDto) {
		reqDto.studentNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi(reqDto.studentNum)) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"), 0)) return new JsonResult(ResultCode.FAIL,"非法请求");
		try {
		String res = dayWeeklyService.weekly_handle(reqDto);
				return new JsonResult(ResultCode.SUCCESS,res);
		}catch(Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 学生的周记查询接口
	 * @param session
	 * @param request
	 * @param model
	 * @param reqDto
	 * @return
	 */
	@ResponseBody
	@PostMapping("/one_weekly")
	public JsonResult get_one_weekly(HttpSession session, HttpServletRequest request, Model model
			,@RequestBody WeeklyHandleReqDto reqDto) {
		reqDto.studentNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi(reqDto.studentNum)) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"), 0)) return new JsonResult(ResultCode.FAIL,"非法请求");
		try {
		JSONObject res = dayWeeklyService.oneWeekly(reqDto);
				return new JsonResult(ResultCode.SUCCESS,"",res);
		}catch(Exception e) {
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 老师的周记评价提交接口
	 * @param session
	 * @param request
	 * @param model
	 * @param reqDto
	 * @return
	 */
	@ResponseBody
	@PostMapping("/teacher_appraise_handle")
	public JsonResult teacher_appraise(HttpSession session, HttpServletRequest request, Model model
			,@RequestBody WeeklyHandleReqDto reqDto) {
		reqDto.teacherNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi(reqDto.teacherNum)) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"), 1)) return new JsonResult(ResultCode.FAIL,"非法请求");
		try {
		String res = dayWeeklyService.teacher_appraise_handle(reqDto);
				return new JsonResult(ResultCode.SUCCESS,res);
		}catch(Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 老师的周记信息查询接口
	 * @param session
	 * @param model
	 * @param reqDto
	 * @return
	 */
	@ResponseBody
	@GetMapping("/appraise_list")
	public JsonResult teacher_appraise_list(HttpSession session, Model model
			, WeeklyHandleReqDto reqDto) {		
		reqDto.teacherNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi(reqDto.teacherNum)) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"), 1)) return new JsonResult(ResultCode.FAIL,"非法请求");
		try {
			JSONArray res = dayWeeklyService.weeklyList(reqDto);
			Integer count = dayWeeklyService.weeklyListCount(reqDto);
				return new JsonResult(ResultCode.SUCCESS,"",count,res);				
		}catch(Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
