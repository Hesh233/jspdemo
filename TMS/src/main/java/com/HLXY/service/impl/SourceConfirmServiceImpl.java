package com.HLXY.service.impl;



import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HLXY.dao.SourceMapper;
import com.HLXY.dto.SourceReqDto;
import com.HLXY.dto.SourceRespdto;
import com.HLXY.entity.Source;
import com.HLXY.service.SourceConfirmService;
import com.HLXY.util.ServerException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Service("sourceConfirmService")
public class SourceConfirmServiceImpl implements SourceConfirmService{
	private static final Logger LOGGER=LoggerFactory.getLogger(DayWeeklyServiceImpl.class);
	@Resource
	private SourceMapper sourceDao;
	/**
	 * 同学核实修改
	 */
	@Override
	public String source_handle(SourceReqDto req) {
		LOGGER.info("source_handle.req="+req.toString());
		List<Source> lst = sourceDao.selcetByStudentNum(req.studentNum);
		if(lst.size() > 1) {
			throw new ServerException("该学生的信息配置有误");
		}
		else if(lst.size() == 1) {
			Source sou = lst.get(0);
			if(sou.getApprove() == SourceReqDto.CONFIRM) {
				throw new ServerException("已经核对过了");
			}
			sou.setApprove(SourceReqDto.CONFIRM);
			sou.setStudentsResource(req.getStudentsResource());
	        sourceDao.updateByPrimaryKey(sou);
		}else {
			Source sou = new Source();
			sou.setStudentsResource(req.getStudentsResource());
			sou.setStudentNum(req.studentNum);
			sou.setCreateTime(Calendar.getInstance().getTime());
			//1=已核对
			sou.setApprove(SourceReqDto.CONFIRM);
			sourceDao.insertSelective(sou);
		}
		return "提交成功";
		
	}
	/**
	 * 老师查询
	 */
	@Override
	public JSONArray teacher_page(SourceReqDto req) {
		LOGGER.info("teacher_page.req="+req.toString());
		//根据周数查询
//		int count = sourceDao.teacherPageCount(req.teacherNum);
//		int page_temp = req.getPage();
//		int limit = req.getLimit();
//		if (count < req.getPage() * limit) {
//			limit = count - (req.getPage() - 1) * limit;
//		}
		req.page = (req.page - 1) * req.limit;
		String ascOrdesc = "asc";
		if(req.ascOrDesc == 1) {
			ascOrdesc = "desc";
		}
		List<Map<Object,Object>> weeklyList = sourceDao.teacherPage(req.teacherNum,req.page,req.limit,ascOrdesc);
		String jStr = JSON.toJSONString(weeklyList);
		JSONArray ja = JSONArray.parseArray(jStr);
		return ja;
		
	}
	/**
	 * 统计条数
	 */
	@Override
	public Integer teacher_page_count(int teacherNum) {
		int count = sourceDao.teacherPageCount(teacherNum);
		return count;
	}
	/**
	 * 学生单条查询
	 */
	@Override
	public SourceRespdto student_confirm_page(Integer studentNum) {
		LOGGER.info("student_confirm_page.studentNum="+studentNum);
		List<Source> lst = sourceDao.selcetByStudentNum(studentNum);
		if(lst.size() > 1) {
			throw new ServerException("该学生的信息配置有误,数据超过一条");
		}else {			
			if(lst.size() != 0) {
				SourceRespdto resp = new SourceRespdto(lst.get(0));
				return resp;
			}
		}
		return null;
	}
	/**
	 * 老师批量添加，修改
	 */
	@Override
	@Transactional
	public String sourceInfChange(JSONArray jsonArray) {
		LOGGER.info("sourceInfChange.jsonArray="+jsonArray.toString());
		//放外层查询该老师负责的学生号
        for (int i = jsonArray.size() -1; i >= 0 ; i--) {
        	JSONObject jo = (JSONObject) jsonArray.get(i);     //将array中的数据进行逐条转换
        	if(jo.get("id") != null) {           
	            //TODO 不能修改不是自己学生的信息先查询一次
	            Source sou = new Source();
	            sou.setId((Integer) jo.get("id"));
	            sou.setStudentsResource((String) jo.get("studentsResource"));
	            //学生核对，老师更新都只能是未核对状态
	            sou.setApprove(0);
	            sourceDao.updateSource(sou);

        	}else {
        		List<Source> lst = sourceDao.selcetByStudentNum(Integer.parseInt((String)jo.get("studentNum")));
        		if(lst.size() > 0) {
        			throw new ServerException("已有该数据");
        		}
        		//没有id就新增数据
    			Source sou = new Source();
    			sou.setStudentsResource((String) jo.get("studentsResource"));
    			sou.setStudentNum(Integer.parseInt((String)jo.get("studentNum")));    			
    			sou.setCreateTime(Calendar.getInstance().getTime());
    			//1=已核对
    			sou.setApprove(SourceReqDto.NOT_CONFIRM);
    			sourceDao.insertSelective(sou);
        	}
        }
		return "更新成功";
	}
}
