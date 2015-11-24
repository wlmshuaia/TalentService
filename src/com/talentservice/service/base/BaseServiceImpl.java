package com.talentservice.service.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.dao.base.BaseDao;
import com.talentservice.domain.File;

@Component("baseService")
public class BaseServiceImpl implements BaseService {
	
	@Resource(name="baseDao")
	private BaseDao baseDao ;
	
	public Collection getAll(Class clazz) {
		return this.baseDao.getAllEntry(clazz);
	}

	public Collection getByPage(Class clazz, String sql, int start, int size) {
		return this.baseDao.getEntryByPage(clazz, sql, start, size);
	}

	public Object getById(Class clazz, Serializable id) {
		return this.baseDao.getEntryById(clazz, id) ;
	}
	
	public Object getEntityByHql(String hql) {
		return this.baseDao.getEntityByHql(hql) ;
	}
	
	@Transactional(readOnly=false)
	public Object update(Object t) {
		return this.baseDao.updateEntry(t);
	}
	
	@Transactional(readOnly=false)
	public Object save(Object t) {
		return this.baseDao.saveEntry(t);
	}
	
	@Transactional(readOnly=false)
	public void delete(Object t) {
		this.baseDao.deleteEntry(t);
	}
	
	@Transactional(readOnly=false)
	public void deleteByIds(Class clazz, String ids) {
		String[] delIds = ids.split(",") ;
		
		for(String id : delIds){
			this.baseDao.deleteEntry(this.baseDao.getEntryById(clazz, Long.parseLong(id))) ;
		}
	}

	public Collection queryByHql(String hql) {
		return this.baseDao.queryByHql(hql);
	}
	
	@Transactional(readOnly=false)
	public Long executeSql(String sql) {
		return this.baseDao.executeSql(sql);
	}

	public InputStream download(Long id) throws FileNotFoundException {
		File file = (File) this.baseDao.getEntryById(File.class, id) ;
		try {
			String fileName = URLEncoder.encode(file.getFilename(), "utf-8");
			ActionContext.getContext().put("fileName", fileName) ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return new FileInputStream(new java.io.File(file.getUrl()));
	}

	public Collection getListById(Class clazz, String idName, Serializable id) {
		return this.baseDao.getListById(clazz, idName, id);
	}

	public int getCount(Class clazz, String hql) {
		return this.baseDao.getCount(clazz, hql) ;
	}

}
