package com.HLXY.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HLXY.dto.LoginReqDto;
import com.HLXY.entity.Info;
import com.HLXY.service.UserService;
import com.HLXY.util.CaptchaUtil;
import com.HLXY.util.CsrfToken;
import com.HLXY.util.JsonResult;
import com.HLXY.util.ReSessionId;
import com.HLXY.util.ResultCode;



@Controller
@Scope(value = "prototype")
@RequestMapping("/user")
public class UserController  extends BaseController{
	@Value("${TMS.version}")
	private  String version;
	@Autowired
	private UserService userService;
	/**
	 * 测试admin模版
	 * @param model
	 * @return
	 */
	@RequestMapping("/userIndex")
	public String toAdminIndex(HttpSession session,Model model,HttpServletRequest request) {
//		model.addAttribute("msg",msg);
//		session.setAttribute("type", 0);
//		session.setAttribute("userId", 1001);
		if(!checkSeesionApi((Integer)session.getAttribute("type"))) return "redirect:/user/login";
		model.addAttribute("version",version);
		ReSessionId.reGenerateSessionId(request);
		return "user/userIndex";
	}
	/**
	 * 登录首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String toIndex(Model model) {
//		model.addAttribute("msg",msg);
		return "user/login";
	}
	/**
	 * 登录页
	 * @param session
	 * @param request
	 * @param model
	 * @param loginCookieUserName
	 * @return
	 */
	@RequestMapping("/login")
	public String tologin(HttpSession session, HttpServletRequest request, Model model,
			@CookieValue(value = "loginCookieUserName", required = false) String loginCookieUserName) {
		String csrf = CsrfToken.getCsrfToken();
		session.setAttribute("csrf_token", csrf);
		model.addAttribute("title", "登录");
		// System.out.println(loginCookieUserName);
		if (loginCookieUserName != null) {
			model.addAttribute("uname", loginCookieUserName);
		}
		return toIndex(model);
	}
	/**
	 * 处理登录
	 * @param csrf_token
	 * @param response
	 * @param session
	 * @param userInfo
	 * @param checkbox
	 * @param request 
	 * @param model
	 * @return
	 */
	@ResponseBody
	@PostMapping("login_handle")
	public JsonResult login_handle(
			HttpSession session,
			Model model,@RequestBody LoginReqDto req) {// @CookieValue(value																											// lasturl,
		System.out.println(req.csrf_token);
		String codeSession = (String) session.getAttribute("code");  
		if(!req.captcha.equals(codeSession)) {
			return new JsonResult(ResultCode.FAIL,"验证码错误");}		
		if (req.csrf_token == null) {
			{return new JsonResult(ResultCode.FAIL);}
		} else if (req.csrf_token != null 
				&& !(req.csrf_token.equals(session.getAttribute("csrf_token")))) {
			 return new JsonResult(ResultCode.FAIL);}
		Info user_handle = userService.Login_handle(req.getUserName(), req.getPassword());
		if (user_handle != null) {
			session.setAttribute("username", user_handle.getName());
			session.setAttribute("userId", user_handle.getUserNum());
			session.setAttribute("type", user_handle.getUserType());
			session.setAttribute("last_login", user_handle.getLastLogin());
			return new JsonResult(ResultCode.SUCCESS);
		} else {

			return new JsonResult(ResultCode.FAIL,"用户名或密码错误");
		}
	}
	@RequestMapping("/quitlogin")
	public String quitlogin(HttpSession session, Model model) {
		session.invalidate();
		return "redirect:/user/login";
	}
	@RequestMapping("/check")  
	/** 
     * 验证码创建
     */ 
    public void createCode(HttpServletRequest request,HttpServletResponse response
    		,HttpSession session) throws IOException {  
        // 通知浏览器不要缓存  验证码Controller部分
        response.setHeader("Expires", "-1");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Pragma", "-1");  
        CaptchaUtil util = CaptchaUtil.Instance();  
        // 将验证码输入到session中，用来验证  
        String code = util.getString();  
        session.setAttribute("code", code);  
        // 输出打web页面  
        ImageIO.write(util.getImage(), "jpg", response.getOutputStream());  
    } 
}
