package com.HLXY.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HLXY.dao.NoticeMapper;
import com.HLXY.dto.NoticeReqDto;
import com.HLXY.entity.Notice;
import com.HLXY.service.NoticeService;
import com.HLXY.util.DateUtil;
import com.HLXY.util.ServerException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeServiceImpl.class);
	@Resource
	private NoticeMapper noticeDao;
	/**
	 * 学生\老师查看通知
	 * 学生在时间段内，而且有查询限制，1的只能是指导老师发的
	 */
	@Override
	public JSONArray notice_page(NoticeReqDto req) {
		LOGGER.info("notice_page="+req.toString());
		req.page = (req.page - 1) * req.limit;
		List<Map<Object,Object>> noticeList ;
		if(req.sessType == 0) {//学生
			noticeList = noticeDao.selectNotice(null,req.studentNum,req.type,req.page,req.limit);

		}else {
			noticeList = noticeDao.selectNotice(1,null,req.type,req.page,req.limit);
		}
		String jStr = JSON.toJSONString(noticeList);
		JSONArray ja = JSONArray.parseArray(jStr);
		return ja;
	}
	/**
	 * 统计行
	 */
	@Override
	public Integer notice_page_count(NoticeReqDto req) {
		LOGGER.info("notice_page="+req.toString());
		Integer count = null;
		if(req.sessType == 0) {//学生
			count = noticeDao.selectNoticeCount(null,req.studentNum,req.type);

		}else {
			count = noticeDao.selectNoticeCount(1,null,req.type);
		}
		return count;
	}
	
	
	/**
	 * 教师修改数据,只能修改自己的
	 * @param jsonArray
	 * @param teacherNum
	 * @return
	 */
	@Override
	@Transactional
	public String notice_inf_change(NoticeReqDto req,Integer teacherNum) {
		LOGGER.info("recruitInfChange.req="+req.toString()+"  teacherNum="+teacherNum);
		//放外层查询该老师负责的学生号
		if(req.title.length() >= 50)throw new ServerException("标题字数不超过50");
		if(req.entryeeInfo.length() >= 500)throw new ServerException("信息字数不超过500");
        	if(req.id != null ) {    
        		Notice sel = noticeDao.selectByPrimaryKey(req.id);
//        		Notice not = new Notice();
        		sel.setEndTime(DateUtil.parse(req.endTime,"yyyy-mm-dd"));
        		sel.setStartTime(DateUtil.parse(req.startTime,"yyyy-mm-dd"));
        		sel.setEntryeeInfo(req.entryeeInfo);
        		sel.setTitle(req.title);
        		sel.setType(req.type);
        	//	not.setTeacherId(req.teacherNum);
        		if(req.getTeacherNum() != sel.getTeacherId()) {
        			throw new ServerException("只能修改自己的信息");
        		}
        		noticeDao.updateByPrimaryKeySelective(sel);

        	}else {
        		Notice not = new Notice();
        		not.setEndTime(DateUtil.parse(req.endTime,"yyyy-mm-dd"));
        		not.setStartTime(DateUtil.parse(req.startTime,"yyyy-mm-dd"));
        		not.setEntryeeInfo(req.entryeeInfo);
        		not.setTitle(req.title);
        		not.setType(req.type);
        		not.setTeacherId(req.teacherNum);
        		
        		noticeDao.insertSelective(not);
        	}      
		return "更新成功";
	}
	/**
	 * 老师批量删除
	 */
	@Override
	@Transactional
	public String notice_inf_del(String str,Integer teacherNum) {
		LOGGER.info("notice_inf_del.str="+str);
    	if(str == null) {      
    		throw new ServerException("删除失败，没有数据") ;
    	}
		List<Notice> lst = new ArrayList<Notice>();
		str = str.substring(1,str.length()-1);
		String[] strs = str.split(",");
        for (String s:strs) {
        	if(s == null) {      
        		throw new ServerException("删除失败，没有该"+s+"记录") ;
        	}else {
        		Notice not = noticeDao.selectByPrimaryKey(Integer.parseInt(s));      		
        		if (not  != null) {
        			lst.add(not);
//        			Notice sel = noticeDao.selectByPrimaryKey(Integer.parseInt(s));
               		if(not.getTeacherId() != teacherNum) {
            			throw new ServerException("只能修改自己的信息");
            		}
        			noticeDao.deleteByPrimaryKey(Integer.parseInt(s));
        		}else {
        			throw new ServerException("删除失败，没有该"+s+"记录") ;
        		}
        	}
        }
        for(Notice i:lst) {
        	LOGGER.warn("通知信息老师号="+teacherNum+"删除了数据 "+i.toString());
        }        
		return "删除成功";
	}
/**
 * 学生,老师查询单条通知，用于修改时
 */
	@Override
	public Map<String,Object> select_one(Integer sessType,Integer id,Integer userId){
		Map<String,Object> map = null;
		if(sessType == 0 ) {
			boolean flag = false;
			List<Integer> checkId = noticeDao.checkSelectId(userId);
			for(Integer i:checkId) {
				if(i == id) {
					flag = true;
				}
			}
			if(flag) {
				map = noticeDao.selectOne(id);
			}			
		}else {
			map = noticeDao.selectOne(id);
		}
		
		return map;
	}
}
