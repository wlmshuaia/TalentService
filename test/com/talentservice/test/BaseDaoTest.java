package com.talentservice.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.talentservice.domain.Province;
import com.talentservice.service.base.BaseService;

public class BaseDaoTest extends BaseSpring {
	
	@Test
	public void testGetAll() {
		BaseService baseService = (BaseService) context.getBean("baseService");
		
		Province pp = new Province() ;
		Class clazz = pp.getClass() ;
		List<Province> ps = (List<Province>) baseService.getAll(clazz) ;
		
		for(Province p : ps){
			System.out.print(p.getProvincename()+" ");
		}
		System.out.println();
		
	}
	
	@Test
	public void testGetEntryByPage() {
		BaseService baseService = (BaseService) context.getBean("baseService");
		
		Province pp = new Province() ;
		Class clazz = pp.getClass() ;
		List<Province> ps = (List<Province>) baseService.getByPage(clazz, "", 3, 3);
		
		for(Province p : ps){
			System.out.print(p.getProvincename()+" ");
		}
		System.out.println();
		
	}
	
	@Test
	public void testGetById() {
		BaseService baseService = (BaseService) context.getBean("baseService");
		
		Province pp = new Province() ;
		Class clazz = pp.getClass() ;
		
		Province p = (Province) baseService.getById(clazz, Long.parseLong("1")) ;
		System.out.println("provincename: "+p.getProvincename());
	}
	
	@Test
	public void testSave() {
		BaseService baseService = (BaseService) context.getBean("baseService");
		
		Province pp = new Province() ;
		Class clazz = pp.getClass() ;
		
		Province p = new Province() ;
		p.setProvincename("新疆") ;
		
		pp = (Province) baseService.save(p) ;
		
		System.out.println("pid: "+pp.getPid());
	}
	
	
	@Test
	public void testUpdate() {
		BaseService baseService = (BaseService) context.getBean("baseService");
		
		Province pp = new Province() ;
		Class clazz = pp.getClass() ;
		
		pp.setPid((long) 11) ;
		pp.setProvincename("广南") ;
		
		Province p = (Province) baseService.update(pp) ;
		System.out.println("provincename: "+p.getProvincename());
	}
	
	@Test
	public void testDelete() {
		BaseService baseService = (BaseService) context.getBean("baseService");
		
		Province pp = new Province() ;
		Class clazz = pp.getClass() ;
		
		pp.setPid((long)13) ;
		
		baseService.delete(pp) ;
	}
	
	@Test
	public void testDeleteByIds() {
		BaseService baseService = (BaseService) context.getBean("baseService");
		
		Province pp = new Province() ;
		Class clazz = pp.getClass() ;
		
		String ids = "11,12," ;
		
		baseService.deleteByIds(clazz, ids) ;
	}
	
}
