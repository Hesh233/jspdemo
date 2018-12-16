package com.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.springboot.dao.LevelDao;
import com.springboot.dao.SchoolDao;
import com.springboot.entity.LevelEntity;
import com.springboot.entity.SchoolDataEntity;

@Service
public class SchoolService {

	@Resource
	private SchoolDao schoolDao;
	@Resource
	private LevelDao levelDao;

	/**
	 * save,update ,delete 方法需要绑定事务. 使用@Transactional进行事务的绑定.
	 *
	 * @param User
	 *            保存对象
	 */
	@Transactional
	public boolean ExistsById(Integer id) {
		return schoolDao.existsById(id);
	}

	/**
	 * 获取列表
	 */
	public List<SchoolDataEntity> list() {
		return schoolDao.findAll();
	}

	@Transactional

	public void save(SchoolDataEntity model) {
		schoolDao.save(model);
	}

	// //@Transactional
	//
	// public T_Cod_SchoolDataModel update(T_Cod_SchoolData model)
	// {
	// schoolDao.(model);
	// }
	@Transactional

	public void delete(SchoolDataEntity model) {
		schoolDao.delete(model);

	}

	public List<SchoolDataEntity> search() {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		List<SchoolDataEntity> lst = schoolDao.findAll(new Specification<SchoolDataEntity>() {
			@Override
			public Predicate toPredicate(Root<SchoolDataEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicate = new ArrayList<>();
				// Path<String> nameExp = root.get("sName");
				predicate.add(cb.equal(root.get("id").as(Integer.class), 1));
				//predicate.add(cb.equal(root.get("sName").as(String.class), "1"));
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		}, sort);
		return lst;
	}

	public List<LevelEntity> searchLevel() {
		
		// 增
		LevelEntity l = new LevelEntity(2, "1", 1, new Date(118, 9, 1));
		levelDao.save(l);
		// 查
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		// 没有分页
		List<LevelEntity> lst = levelDao.findAll(new Specification<LevelEntity>() {
			@Override
			public Predicate toPredicate(Root<LevelEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//这里把eeid关联到另一个表的id
				Join<LevelEntity, SchoolDataEntity> join = root.join("sData", JoinType.LEFT);//outer join
				List<Predicate> predicate = new ArrayList<>();
				// Path<String> nameExp = root.get("sName");
				predicate.add(cb.equal(root.get("eeid").as(Integer.class), 1));
				predicate.add(cb.equal(root.get("level").as(String.class), "1"));
				//predicate.add(cb.equal(root.join("sData").get("id").as(Integer.class),1));
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		}, sort);
		// 删
		// levelDao.deleteAll(lst);
		// List<Level> lst = levelDao.findAll();
		for (LevelEntity i:lst) {
			System.out.println(i.toString());
		}
		return lst;
	}

	/**
	 * 有分页的请求
	 * 
	 * @return
	 */
	public Page<LevelEntity> setPage() {
		// 有分页
		PageRequest pageRequest = buildPageRequest(2, 5, "auto");
		Page<LevelEntity> page = levelDao.findAll(new Specification<LevelEntity>() {
			@Override
			public Predicate toPredicate(Root<LevelEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicate = new ArrayList<>();
				// Path<String> nameExp = root.get("sName");
				// predicate.add(cb.equal(root.get("id").as(Integer.class), 2));
				// predicate.add(cb.equal(root.get("level").as(String.class), "2"));
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		}, pageRequest);
		return page;
	}

	public List<LevelEntity> getPage() {
		// 有分页
		PageRequest pageRequest = buildPageRequest(2, 5, "auto");
		List<LevelEntity> page = levelDao.findAll(new Specification<LevelEntity>() {
			@Override
			public Predicate toPredicate(Root<LevelEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicate = new ArrayList<>();
				// Path<String> nameExp = root.get("sName");
				// predicate.add(cb.equal(root.get("id").as(Integer.class), 2));
				// predicate.add(cb.equal(root.get("level").as(String.class), "2"));
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		}, pageRequest).getContent();
		return page;
	}

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null; // 排序条件,后面可以自己加
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}
//		PageRequest pageRequest = new PageRequest(pageNumber - 1, pagzSize, sort);
		return PageRequest.of(pageNumber - 1, pagzSize, sort);
	}

}
