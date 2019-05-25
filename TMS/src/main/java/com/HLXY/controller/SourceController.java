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

import com.HLXY.dto.SourceReqDto;
import com.HLXY.service.SourceConfirmService;
import com.HLXY.util.JsonResult;
import com.HLXY.util.ResultCode;
import com.alibaba.fastjson.JSONArray;

@Controller
@Scope(value = "prototype")
@RequestMapping("/source")
public class SourceController extends BaseController{
	@Autowired
	private SourceConfirmService sourceConfirmService;
	/**
	 * 根据用户类型返回就业信息页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/source_data")
	public String data_page(HttpSession session, Model model) {
		Integer type= (Integer) session.getAttribute("type");
		Integer userId = (Integer) session.getAttribute("userId");
		if(type == null) return "redirect:/user/login";
		if(type == 0) {
			model.addAttribute("source",sourceConfirmService.student_confirm_page(userId));
			return "source/sourceForm";
		}else{
			return "source/sourceData";
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
	@GetMapping("/teacher_page")
	public JsonResult teacher_appraise_list(HttpSession session, Model model
			, SourceReqDto req) {		
		req.teacherNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"),1)) return new JsonResult(ResultCode.FAIL,"非法请求");	
		try {
			JSONArray res = sourceConfirmService.teacher_page(req);
			Integer count = sourceConfirmService.teacher_page_count(req.teacherNum);
				return new JsonResult(ResultCode.SUCCESS,"",count,res);				
		}catch(Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 修改生源地信息
	 */
	@ResponseBody
	@PostMapping("/source_inf_change")
	public JsonResult approve_inf_change(@RequestParam("datas")String datas, HttpSession session, HttpServletRequest request, Model model) {
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"),1)) return new JsonResult(ResultCode.FAIL,"非法请求");	
		try {
			JSONArray jsonArray = JSONArray.parseArray(datas);
			String res = sourceConfirmService.sourceInfChange(jsonArray);
			return new JsonResult(ResultCode.SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 查询一条学生记录
	 * @param session
	 * @param model
	 * @param req
	 * @return
	 */
	@ResponseBody
	@GetMapping("/one_student")
	public JsonResult one_student(HttpSession session, Model model
			, SourceReqDto req) {		
		req.studentNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"),1)) return new JsonResult(ResultCode.FAIL,"非法请求");	
		try {
				return new JsonResult(ResultCode.SUCCESS,sourceConfirmService.student_confirm_page(req.studentNum).toString());				
		}catch(Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
	/**
	 * 学生生源地信息提交接口
	 * @param req
	 * @param session
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@PostMapping("source_handle")
	public JsonResult source_handle(@RequestBody SourceReqDto req, HttpSession session, HttpServletRequest request, Model model) {
		req.studentNum = (Integer) session.getAttribute("userId");
		if(!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL,"非法请求");
		if(checkType((Integer) session.getAttribute("type"),0)) return new JsonResult(ResultCode.FAIL,"非法请求");	
		if(!checkSeesionApi(req.studentNum)) return new JsonResult(ResultCode.FAIL,"非法请求");		
		try {
			String res = sourceConfirmService.source_handle(req);
			return new JsonResult(ResultCode.SUCCESS, res);
		} catch (Exception e) {
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
