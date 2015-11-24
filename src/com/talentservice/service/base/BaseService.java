package com.talentservice.service.base;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;

public interface BaseService {
	/**
	 * 查询所有实体
	 * @param clazz
	 * @return
	 */
	public Collection getAll(Class clazz) ;
	
	/**
	 * 查询当前页实体列表
	 * @param sql
	 * @param from
	 * @param size
	 * @return
	 */
	public Collection getByPage(Class clazz, String sql, int start, int size);
	
	/**
	 * 根据 id 查询所有实体列表，适用于存在外键情况
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Collection getListById(Class clazz, String idName, Serializable id) ;
	
	/**
	 * 根据id查询实体
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object getById(Class clazz,Serializable id) ;
	
	/**
	 * 根据 hql 查询一个实体
	 * @param hql
	 * @return
	 */
	public Object getEntityByHql(String hql) ;
	
	/**
	 * 查询实体列表
	 * @param hql
	 * @return
	 */
	public Collection queryByHql(String hql) ;
	
	/**
	 * 执行一条sql语句
	 * @param sql
	 * @return
	 */
	public Long executeSql(String sql);
	
	/**
	 * 根据 hql 获取数量
	 * @param clazz
	 * @param hql
	 * @return
	 */
	public int getCount(Class clazz, String hql) ;
	
	/**
	 * 更新实体
	 * @param t
	 * @return
	 */
	public Object update(Object t);
	
	/**
	 * 添加实体
	 * @param t
	 * @return
	 */
	public Object save(Object t) ;
	
	/**
	 * 删除实体
	 * @param t
	 */
	public void delete(Object t) ;
	
	/**
	 * 删除多个实体
	 * @param ids
	 */
	public void deleteByIds(Class clazz, String ids) ;
	
	/**
	 * 下载
	 * @param id
	 * @return
	 */
	public InputStream download(Long id) throws FileNotFoundException ;
	
}
