package com.springboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.LevelEntity;
import com.springboot.entity.SchoolDataEntity;
import com.springboot.service.SchoolService;

import net.sf.json.JSONArray;

@RestController

public class CodSchoolController {

	@Autowired
	private SchoolService schoolService;

	@GetMapping(value = "/getId")
	public String getByName() {
		int Id;
		boolean b = schoolService.ExistsById(1);
		if (b) {
			return "The   id is exist.";
		}
		return "user id is not exist.";
	}

	@GetMapping(value = "/list")
	public String getList() {
		List<SchoolDataEntity> lst = schoolService.list();
		if (lst != null && lst.size() > 0) {

			JSONArray jsonArray = JSONArray.fromObject(lst);// 将取到的lst对应的(一组)值字符串转换为JSONArray

			// 将取到的cartypes对应的(一组)值字符串转换为JSONArray

			return jsonArray.toString();
		}
		return "";
	}

	@GetMapping("/save")
	public String save() {
		try {

			SchoolDataEntity model = new SchoolDataEntity();
			model.setsName("李四");
			// SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			model.setProvince("上海");
			model.setCreatetime(new Date());
			schoolService.save(model);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			return "save success.";
		}

	}

	@RequestMapping("/delete/{id}")

	public String delete() {
		try {
			SchoolDataEntity model = new SchoolDataEntity();
			model.setId(1);
			schoolService.delete(model);
		} catch (Exception e) {
			throw e;
		} finally {
			return "执行了删除操作!";
		}
	}

	@RequestMapping("/select")
	public String select() {
		 //List<SchoolDataEntity> lst = schoolService.search();
		List<LevelEntity> lst = schoolService.searchLevel();
		if (lst != null && lst.size() > 0) {

			JSONArray jsonArray = JSONArray.fromObject(lst);// 将取到的lst对应的(一组)值字符串转换为JSONArray

			// 将取到的cartypes对应的(一组)值字符串转换为JSONArray
			return jsonArray.toString();
		}
		return "条件找不到";
	}

	@RequestMapping("/selectpage")
	public Page<LevelEntity> selectPage() {
		Page<LevelEntity> page = schoolService.setPage();
		return page;
	}

	@RequestMapping("/getpage")
	public String getPage() {
		// List<T_Cod_SchoolData> lst = schoolService.search();
		List<LevelEntity> lst = schoolService.getPage();
		if (lst != null && lst.size() > 0) {
			JSONArray jsonArray = JSONArray.fromObject(lst);// 将取到的lst对应的(一组)值字符串转换为JSONArray
			// 将取到的cartypes对应的(一组)值字符串转换为JSONArray
			return jsonArray.toString();
		}
		return "条件找不到";
	}
}
