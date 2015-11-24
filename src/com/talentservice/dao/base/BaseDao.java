package com.talentservice.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseDao {
	/**
	 * 获取该表下所有数据
	 * @param classz
	 * @return
	 */
	public Collection getAllEntry(Class classz) ;
	
	/**
	 * 查询当前页实体
	 * @param classz
	 * @param sql
	 * @param start
	 * @param size
	 * @return
	 */
	public Collection getEntryByPage(final Class clazz, final String sql, final int start, final int size) ;
	
	/**
	 * 根据 id 查询所有实体列表，适用于存在外键情况
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Collection getListById(Class clazz, String idName, Serializable id) ;

	/**
	 * 根据指定 id 获取数据
	 * @param classz
	 * @param id
	 * @return
	 */
	public Object getEntryById(Class classz, Serializable id) ;
	
	/**
	 * 根据 hql 查询一个实体
	 * @param hql
	 * @return
	 */
	public Object getEntityByHql(String hql) ;
	
	/**
	 * 根据 hql 查询实体列表
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
	 * 根据指定 hql 获取数量
	 * @param clazz
	 * @param hql
	 * @return
	 */
	public int getCount(Class clazz, String hql) ;
	
	/**
	 * 保存实体
	 * @param t
	 * @return
	 */
	public Object saveEntry(Object t) ;
	
	/**
	 * 更新实体
	 * @param t
	 * @return
	 */
	public Object updateEntry(Object t) ;
	
	/**
	 * 删除实体
	 * @param t
	 */
	public void deleteEntry(Object t) ;

}
