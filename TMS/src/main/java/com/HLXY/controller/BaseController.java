package com.HLXY.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BaseController {
/**
 * 校验session是否为空
 */
	public String checkSessionPage(Object value) {
		if(value == null) {
			return "redirect:/user/login";
		}
		return null;
	}
	public boolean checkSeesionApi(Object value) {
		if(value == null) {
			return false;
		}
		return true;
	}
	public boolean checkType(Integer type ,Integer realType) {
		if(type == realType) {
			return false;
		}
		return true;
	}

	    @RequestMapping("/")
	    public String index()  {
	        return "redirect:/user/login";
	    
	}
}
