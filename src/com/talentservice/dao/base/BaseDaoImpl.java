package com.talentservice.dao.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;


@Component("baseDao")
public class BaseDaoImpl implements BaseDao {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate ;
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory ;
	
	private static Logger logger = Logger.getLogger(HibernateTemplate.class);
	
	public Collection getAllEntry(Class classz) {
		return this.hibernateTemplate.find("from "+classz.getName());
	}
	
	public Collection getEntryByPage(final Class clazz, final String sql, final int start, final int size) {
		return this.hibernateTemplate.execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				return session.createQuery("from " + clazz.getName()+" where 1=1 "+sql)
						.setFirstResult(start).setMaxResults(size).list();
			}
		});
	}
	
	public Object getEntryById(Class classz, Serializable id) {
		return this.hibernateTemplate.get(classz.getName(), id);
	}

	public Object getEntityByHql(String hql) {
		List entities = this.hibernateTemplate.find(hql) ;
		
		if(entities.size() > 0)  return entities.get(0);
		return null;
	}
	
	public Collection queryByHql(String hql) {
		return this.hibernateTemplate.find(hql);
	}
	
	public Object saveEntry(Object t) {
		this.hibernateTemplate.save(t) ;
		return t ;
	}

	public Object updateEntry(Object t) {
		this.hibernateTemplate.saveOrUpdate(t) ;
		return t ;
	}

	public void deleteEntry(Object t) {
		this.hibernateTemplate.delete(t) ;
	}

	public Long executeSql(String sql) {
		Long c = 0L;
		Session session = sessionFactory.openSession() ;
		Query query = session.createSQLQuery(sql);
		Object count = query.executeUpdate();
		if(null != count) {
			c = Long.parseLong(count.toString());
		}
		return c;
	}

	public Collection getListById(Class clazz, String idName, Serializable id) {
		return this.hibernateTemplate.find("from "+clazz.getName()+" where "+idName+" = "+id) ;
	}

	public int getCount(Class clazz, String hql) {
		return this.hibernateTemplate.find("from "+clazz.getName()+" where 1=1 "+hql).size();
	}

}
