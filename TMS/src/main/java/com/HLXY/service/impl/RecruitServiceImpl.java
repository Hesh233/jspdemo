package com.HLXY.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HLXY.dao.RecruitMapper;
import com.HLXY.dao.RecruitTypeMapper;
import com.HLXY.dto.RecruitReqDto;
import com.HLXY.dto.RecruitResp;
import com.HLXY.entity.Recruit;
import com.HLXY.entity.RecruitType;
import com.HLXY.service.RecruitService;
import com.HLXY.util.DateUtil;
import com.HLXY.util.ServerException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Service("recrutiService")
public class RecruitServiceImpl implements RecruitService{
	private static final Logger LOGGER = LoggerFactory.getLogger(RecruitServiceImpl.class);
	@Resource
	private RecruitMapper recruitDao;
	@Resource
	private RecruitTypeMapper recruitTypeDao;
	/**
	 * 老师\学生查看招聘信息
	 */
	@Override
	public JSONArray recruit_page(RecruitReqDto req) {
		LOGGER.info("recruit_student_page.req="+req.toString());
		//int count = recruitDao.selectRecruitCount(req.interviewType);
	//	int page_temp = req.getPage();
	//	int limit = req.getLimit();
	//	if (count < req.getPage() * limit) {
		//	limit = count - (req.getPage() - 1) * limit;
		//}
		req.page = (req.page - 1) * req.getLimit();
		List<Map<Object,Object>> recruitList = recruitDao.selectStudentRecruit(req.interviewType,req.page,req.limit);
		String jStr = JSON.toJSONString(recruitList);
		JSONArray ja = JSONArray.parseArray(jStr);
		return ja;
	}
	/**
	 * 数据条数
	 */
	@Override
	public Integer recruit_page_count(Integer interviewType) {
		return recruitDao.selectRecruitCount(interviewType);
	}
	/**
	 * 老师批量添加，修改招聘信息
	 */
	@Override
	@Transactional
	public String recruit_inf_change(JSONArray jsonArray,Integer teacherNum) {
		LOGGER.info("recruitInfChange.jsonArray="+jsonArray.toString());
		//放外层查询该老师负责的学生号
        for (int i = jsonArray.size() -1; i >= 0 ; i--) {
        	JSONObject jo = (JSONObject) jsonArray.get(i);     //将array中的数据进行逐条转换
        	if(jo.get("id") != null) {      
        		Recruit rec = JSON.toJavaObject(jo,Recruit.class);
        		recruitDao.updateByPrimaryKeySelective(rec);

        	}else {
//        		List<Source> lst = sourceDao.selcetByStudentNum(Integer.parseInt((String)jo.get("studentNum")));
//        		if(lst.size() > 0) {
//        			throw new ServerException("已有该数据");
//        		}
        		//没有id就新增数据
        		//Recruit rec = new Recruit();
        		Recruit rec = JSON.toJavaObject(jo,Recruit.class);
        		recruitDao.insertSelective(rec);
        	}
        }
		return "更新成功";
	}
	/**
	 * 老师批量删除
	 */
	@Override
	@Transactional
	public String recruit_inf_del(String str,Integer teacherNum) {
		LOGGER.info("recruit_inf_del.str="+str);
    	if(str == null) {      
    		throw new ServerException("删除失败，没有该记录") ;
    	}
		List<Recruit> lst = new ArrayList<Recruit>();
		str = str.substring(1,str.length()-1);
		String[] strs = str.split(",");
        for (String s:strs) {
        	if(s == null) {      
        		throw new ServerException("删除失败，没有该记录") ;
        	}else {
        		Recruit rec = recruitDao.selectByPrimaryKey(Integer.parseInt(s));      		
        		if (rec  != null) {
        			lst.add(rec);
        			recruitDao.deleteByPrimaryKey(Integer.parseInt(s));
        		}else {
        			throw new ServerException("删除失败，没有该记录") ;
        		}
        	}
        }
        for(Recruit i:lst) {
        	LOGGER.warn("招聘信息老师号="+teacherNum+"删除了数据 "+i.toString());
        }        
		return "删除成功";
	}
	/**
	 * 查询招聘类型
	 */
	@Override
	public List<RecruitType> type_page(Integer page,Integer limit) {
		if(page != null) {
			page = (page-1)*limit;
		}
		List<RecruitType> reTLst = recruitTypeDao.selectAll(page,limit);		
		return reTLst;
	}
	/**
	 * 查询招聘数量
	 */
	@Override
	public Integer type_count() {
		Integer count = recruitTypeDao.allCount();		
		return count;
	}
	/**
	 * 老师批量添加，修改招聘类型
	 */
	@Override
	@Transactional
	public String recruit_type_change(JSONArray jsonArray,Integer teacherNum) {
		LOGGER.info("recruit_type_change.jsonArray="+jsonArray.toString());
        for (int i = jsonArray.size() -1; i >= 0 ; i--) {
        	JSONObject jo = (JSONObject) jsonArray.get(i);     //将array中的数据进行逐条转换
        	if(jo.get("id") != null ) {      
        		RecruitType rec = JSON.toJavaObject(jo,RecruitType.class);
        		recruitTypeDao.updateByPrimaryKeySelective(rec);
        	}else {
//        		List<Source> lst = sourceDao.selcetByStudentNum(Integer.parseInt((String)jo.get("studentNum")));
//        		if(lst.size() > 0) {
//        			throw new ServerException("已有该数据");
//        		}
        		//没有id就新增数据
        		//Recruit rec = new Recruit();
        		RecruitType rec = JSON.toJavaObject(jo,RecruitType.class);
        		recruitTypeDao.insert(rec);
        	}
        }
		return "更新成功";
	}
	/**
	 * 老师批量删除类型
	 */
	@Override
	@Transactional
	public String recruit_type_del(String str,Integer teacherNum) {
		LOGGER.info("recruit_type_del.str="+str);
    	if(str == null) {      
    		throw new ServerException("删除失败，没有该记录") ;
    	}
		str = str.substring(1,str.length()-1);
		String[] strs = str.split(",");
		List<RecruitType> lst = new ArrayList<RecruitType>();
        for (String s:strs) {
        	if(s == null) {      
        		throw new ServerException("删除失败，没有该记录") ;
        	}else {
        		RecruitType rec = recruitTypeDao.selectByPrimaryKey(Integer.parseInt(s));      		
        		if (rec  != null) {
        			lst.add(rec);
        			recruitTypeDao.deleteByPrimaryKey(Integer.parseInt(s));
        		}else {
        			throw new ServerException("删除失败，没有该记录") ;
        		}
        	}
        }
        for(RecruitType i:lst) {
        	LOGGER.warn("招聘信息老师号="+teacherNum+"删除了数据 "+i.toString());
        }        
		return "删除成功";
	}
	/**
	 * 根据id查询单条记录
	 */
	@Override
	public RecruitResp one_recruit(Integer id) {
		Recruit rec = recruitDao.selectByPrimaryKey(id);	
		RecruitResp re = new RecruitResp(rec);
		return re;
	}
	/**
	 * 修改单条记录
	 */
	@Override
	public String recruit_change(RecruitReqDto req) {
		if(req.positionName.length() >= 20)throw new ServerException("岗位字数不超过20");
		if(req.companyName.length() >= 25)throw new ServerException("公司名不超过25");
		if(req.companyAddress.length() >= 100)throw new ServerException("公司地址不超过100");
		if(req.interviewPlace.length() >= 40)throw new ServerException("面试地点不超过40");
		Recruit rec = new Recruit();
		rec.setCompanyAddress(req.getCompanyAddress());
		rec.setCompanyName(req.getCompanyName());
		rec.setStartTime(DateUtil.parse(req.startTime, "yyyy-MM-dd"));
		rec.setEndTime(DateUtil.parse(req.endTime, "yyyy-MM-dd"));
		rec.setRemark(req.remark);
		rec.setInterviewPlace(req.interviewPlace);
		rec.setInterviewType(req.interviewType);
		rec.setId(req.id);
		rec.setPositionName(req.positionName);
		recruitDao.updateByPrimaryKeySelective(rec);
		return "更新成功";
	}
	/**
	 * 新增单条记录
	 */
	@Override
	public String recruit_add(RecruitReqDto req) {
		if(req.positionName.length() >= 20)throw new ServerException("岗位字数不超过20");
		if(req.companyName.length() >= 25)throw new ServerException("公司名不超过25");
		if(req.companyAddress.length() >= 100)throw new ServerException("公司地址不超过100");
		if(req.interviewPlace.length() >= 40)throw new ServerException("面试地点不超过40");
		Recruit rec = new Recruit();
		rec.setCompanyAddress(req.getCompanyAddress());
		rec.setCompanyName(req.getCompanyName());
		rec.setStartTime(DateUtil.parse(req.startTime, "yyyy-MM-dd"));
		rec.setEndTime(DateUtil.parse(req.endTime, "yyyy-MM-dd"));
		rec.setRemark(req.remark);
		rec.setInterviewPlace(req.interviewPlace);
		rec.setInterviewType(req.interviewType);
		rec.setPositionName(req.positionName);
		rec.setCreateTime(Calendar.getInstance().getTime());
		recruitDao.insertSelective(rec);
		return "更新成功";
	}
}
