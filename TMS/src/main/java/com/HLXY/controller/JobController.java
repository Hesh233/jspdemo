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

import com.HLXY.dto.StuJobReqDto;
import com.HLXY.service.JobService;
import com.HLXY.util.JsonResult;
import com.HLXY.util.ResultCode;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@Scope(value = "prototype")
@RequestMapping("/job")
public class JobController extends BaseController {
    @Autowired
    private JobService jobService;

    //注意不能一样的
    @RequestMapping("/index")
    public String index_page() {
        return "job/indexPage";
    }

    /**
     * 根据用户类型返回就业信息页面
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/job_data")
    public String data_page(HttpSession session, Model model) {
        Integer type = (Integer) session.getAttribute("type");
        Integer userId = (Integer) session.getAttribute("userId");
        if (type == null) return "redirect:/user/login";
        if (type == 0) {
            model.addAttribute("job", jobService.one_Stu(userId));
            return "job/jobForm";
        } else {

            return "job/jobData";
        }
    }

    /**
     * 假装有session的userid测试接口
     * type 0:学生，1：老师
     */
    public int testApi(Integer type) {
        if (type == 0) {
            return 1001;
        } else {
            return 101;
        }
    }

    /**
     * 学生就业信息提交接口
     *
     * @param req
     * @param session
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @PostMapping("stu_job_handle")
    public JsonResult stu_job_handle(@RequestBody StuJobReqDto req, HttpSession session, HttpServletRequest request, Model model) {
        req.studentNum = (Integer) session.getAttribute("userId");
        if (!checkSeesionApi(req.studentNum)) return new JsonResult(ResultCode.FAIL, "非法请求");
        if (checkType((Integer) session.getAttribute("type"), 0)) return new JsonResult(ResultCode.FAIL, "非法请求");
        try {
            String res = jobService.stu_job_handle(req);
            return new JsonResult(ResultCode.SUCCESS, res);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    /**
     * 查看学生单条信息
     */
    @ResponseBody
    @GetMapping("one_stu")
    public JsonResult one_stu(@RequestBody StuJobReqDto req, HttpSession session, HttpServletRequest request, Model model) {
        req.studentNum = (Integer) session.getAttribute("userId");
        if (!checkSeesionApi(req.studentNum)) return new JsonResult(ResultCode.FAIL, "非法请求");
        if (checkType((Integer) session.getAttribute("type"), 0)) return new JsonResult(ResultCode.FAIL, "非法请求");
        if (!checkSeesionApi(req.studentNum)) return new JsonResult(ResultCode.FAIL, "非法请求");
        try {
            return new JsonResult(ResultCode.SUCCESS, jobService.one_Stu(req).toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    /**
     * 老师审批
     */
    @ResponseBody
    @PostMapping("tea_appoave")
    public JsonResult tea_appoave(StuJobReqDto req, HttpSession session, HttpServletRequest request, Model model) {
        req.teaNum = (Integer) session.getAttribute("userId");
        if (!checkSeesionApi(req.teaNum)) return new JsonResult(ResultCode.FAIL, "非法请求");
        if (checkType((Integer) session.getAttribute("type"), 1)) return new JsonResult(ResultCode.FAIL, "非法请求");
        try {
            String res = jobService.teaAppoave(req);
            return new JsonResult(ResultCode.SUCCESS, res);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    /**
     * 老师查看单条记录
     */
    @ResponseBody
    @GetMapping("one_tea_approve")
    public JsonResult one_tea_approve(StuJobReqDto req, HttpSession session, HttpServletRequest request, Model model) {
        req.teaNum = (Integer) session.getAttribute("userId");
        if (!checkSeesionApi(req.teaNum)) return new JsonResult(ResultCode.FAIL, "非法请求");
        if (checkType((Integer) session.getAttribute("type"), 1)) return new JsonResult(ResultCode.FAIL, "非法请求");
        if (!checkSeesionApi(req.teaNum)) return new JsonResult(ResultCode.FAIL, "非法请求");
        try {
            JSONObject res = jobService.oneTeaApprove(req);
            return new JsonResult(ResultCode.SUCCESS, "", res);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    /**
     * 老师查看指导学生列表
     */
    @ResponseBody
    @GetMapping("tea_approveList")
    public JsonResult tea_approveList(StuJobReqDto req, HttpSession session, HttpServletRequest request, Model model) {
        req.teaNum = (Integer) session.getAttribute("userId");
        if (!checkSeesionApi(req.teaNum)) return new JsonResult(ResultCode.FAIL, "非法请求");
        if (checkType((Integer) session.getAttribute("type"), 1)) return new JsonResult(ResultCode.FAIL, "非法请求");
        try {
            JSONArray res = jobService.teaApproveList(req);
            return new JsonResult(ResultCode.SUCCESS, "", jobService.teaApproveListCount(req.teaNum), res);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    /**
     * 修改就业信息
     */
    @ResponseBody
    @PostMapping("approve_inf_change")
    public JsonResult approve_inf_change(@RequestParam("datas") String datas,
                                         HttpSession session) {
        if (!checkSeesionApi((Integer) session.getAttribute("userId"))) return new JsonResult(ResultCode.FAIL, "非法请求");
        if (checkType((Integer) session.getAttribute("type"), 1)) return new JsonResult(ResultCode.FAIL, "非法请求");
        try {
            JSONArray jsonArray = JSONArray.parseArray(datas);
            String res = jobService.approveInfChange(jsonArray);
            return new JsonResult(ResultCode.SUCCESS, res);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }
}
