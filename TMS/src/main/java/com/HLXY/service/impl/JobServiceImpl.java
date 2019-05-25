package com.HLXY.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HLXY.dao.JobMapper;
import com.HLXY.dto.JobRespDto;
import com.HLXY.dto.StuJobReqDto;
import com.HLXY.entity.Job;
import com.HLXY.service.JobService;
import com.HLXY.util.DateUtil;
import com.HLXY.util.ServerException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service("jobServiceService")
public class JobServiceImpl implements JobService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DayWeeklyServiceImpl.class);
	@Resource
	private JobMapper jobDao;

	/**
	 * 查看学生单条信息
	 */
	@Override
	public JSONObject one_Stu(StuJobReqDto req) {
		LOGGER.info("one_Stu.req="+req.toString());
		Job job = jobDao.selectByLastestStudentNum(req.studentNum);
		if (job == null) {
			return null;
		} else {
			return (JSONObject) JSONObject.toJSON(job);
		}
	}
	/**
	 * 查看学生单条信息
	 */
	@Override
	public JobRespDto one_Stu(Integer stuNum) {
		Job job = jobDao.selectByLastestStudentNum(stuNum);
		JobRespDto resp = new JobRespDto(job);
		if (job == null) {
			return null;
		} else {
			return resp;
		}
	}
	/**
	 * 学生就业信息提交
	 * 
	 * @param req
	 * @return
	 */
	@Override
	public String stu_job_handle(StuJobReqDto req) {
		// TODO 可能要删除最旧的后三条记录
			// Job job = jobDao.selectByLastestStudentNum(req.studentNum);
			if(req.phoneNum != null && (req.phoneNum+"").length() > 11) throw new ServerException("电话号码长度超出11位");
			if(req.companyNum != null && (req.companyNum+"").length() > 11) throw new ServerException("电话号码长度超出11位");
			Job job = new Job();
			job.setCompanyAddress(req.companyAddress);
			job.setCreateTime(Calendar.getInstance().getTime());
			job.setStudentNum(req.studentNum);
			job.setCompanyName(req.companyName);
			job.setConfirmState(0);
			job.setPhoneNum(req.phoneNum);
			job.setCompanyNum(req.companyNum);
			jobDao.insertSelective(job);
			return "实习信息提交成功";
	}

	/**
	 * 老师审核
	 * 测试成功
	 * @param req
	 * @return
	 */
	@Override
	public String teaAppoave(StuJobReqDto req) {
		// TODO 不能越权改其他学生(要检查学号是不是该指导老师的)
		// List<Job> jobLst = jobDao.selectStuListAndSort(req.teaNum,null,null);
		// 一键审批
		if (req.stuNums != null) {
			String stuNum[] = req.stuNums.split(",");
			List<Job> lstJob = new ArrayList<Job>();
			for (String i : stuNum) {
				Job job = jobDao.selectByLastestStudentNum(Integer.parseInt(i));
				if (job != null) {
					job.setConfirmState(1);
					lstJob.add(job);
				} else {
					return "不存在学生号为"+ i +"记录";
				}
			}
			for (Job i : lstJob) {
				jobDao.updateByPrimaryKey(i);
			}
			return "审批成功";
		}

		// Job job = new Job();
		// job.setConfirmState(1);
		// job.setStudentNum(req.studentNum);
		Job job = jobDao.selectByLastestStudentNum(req.studentNum);
		if (job != null) {
			job.setConfirmState(1);
		} else {
			return "不存在该记录";
		}
		jobDao.updateByPrimaryKey(job);
		return "审批成功";
	}

	/**
	 * 查看列表
	 * 测试完成
	 */
	@Override
	public JSONArray teaApproveList(StuJobReqDto req) {
		String ascOrdesc = null;
		if (req.ascOrDesc == 0) {
			ascOrdesc = "asc";
		} else {
			ascOrdesc = "desc";
		}
		int count = jobDao.selectStuListAndSortCount(req.teaNum).size();
		int page_temp = req.getPage();
		int limit = req.getLimit();
		if (count < req.getPage() * limit) {
			limit = count - (req.getPage() - 1) * limit;
		}
		req.page = (page_temp - 1)   * req.limit;
		List<Map<Object, Object>> jobLst = jobDao.selectStuListAndSort(req.teaNum, req.sortKey, ascOrdesc,req.page,limit);
		//List<Map<Object, Object>>转jsonObject要特殊转换
		String jStr = JSON.toJSONString(jobLst);
		JSONArray ja = JSONArray.parseArray(jStr);
//		JSONObject myjObject = null;
//		for(int i=0 ; i <  ja.size() ;i++)
//		   {
//		    //获取每一个JsonObject对象
//		    myjObject = ja.getJSONObject(i);
//		}
//		return JSONObject.parseObject(jStr);
		return ja;

	}
	@Override
	public Integer teaApproveListCount(Integer teaNum) {
		return jobDao.selectStuListAndSortCount(teaNum).size();
	}

	/**
	 * 查看单条记录
	 * 测试完成
	 */
	@Override
	public JSONObject oneTeaApprove(StuJobReqDto req) {
		List<Map<Object, Object>> jobLst = jobDao.selectStuListAndSort(req.teaNum, null, null,null,null);
		Job job = jobDao.selectByLastestStudentNum(req.studentNum);
		for (Map<Object, Object> i : jobLst) {
			// 对照记录返回正确
			if (job.getStudentNum().equals( i.get("studentNum"))) {
				//时间转换
				i.put("createTime", DateUtil.format((Date) i.get("createTime"), "yyyy-MM-dd"));
				return JSONObject.parseObject(JSON.toJSONString(i));
			//	return (JSONObject) JSONObject.toJSON(job);
			}
		}
		// 不对照
		return null;
	}
/**
 * 批量修改学生记录,只能修改公司名和地址和审批
 */
	@Transactional
	@Override
	public String approveInfChange(JSONArray jsonArray) {
//		for(Job i:jobLst) {
//			jobDao.updateByPrimaryKey(i);
//		}
        //TODO 不能修改不是自己学生的信息
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jo = (JSONObject) jsonArray.get(i);     //将array中的数据进行逐条转换     
            if(jo.get("companyNum") != null && ((String)jo.get("companyNum")).length() > 11)throw new ServerException("电话号码长度超出11位");
        	if(jo.get("phoneNum") != null && ((String)jo.get("phoneNum")).length() > 11) throw new ServerException("电话号码长度超出11位");
            try {
            	String companyNum = (String)jo.get("companyNum");
            	String phoneNum = (String)jo.get("phoneNum");
            	if(companyNum != null) Integer.parseInt(companyNum);           	
            	if(phoneNum != null) Integer.parseInt(phoneNum);
            } catch (Exception e) {
            	throw new ServerException("电话号码输入不是数字");
            }  
            Job job = new Job();
    		if(((String) jo.get("companyName")).length() >= 50)throw new ServerException("公司名不超过50");
    		if(((String) jo.get("companyAddress")).length() >= 1000)throw new ServerException("公司地址不超过100");
            job.setCompanyName((String) jo.get("companyName"));
            job.setCompanyAddress((String) jo.get("companyAddress"));
            job.setStudentNum((Integer) jo.get("studentNum"));
            job.setConfirmState((Integer) jo.get("comfirmState"));
            if(jo.get("phoneNum") != null) job.setPhoneNum((String)jo.get("phoneNum"));
            if(jo.get("companyNum") != null) job.setCompanyNum((String)jo.get("companyNum"));
            jobDao.updateByLatestStuNumSelective(job);
        }
		return "更新成功";
	}
}
