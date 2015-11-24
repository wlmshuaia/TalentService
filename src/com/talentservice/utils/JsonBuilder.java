package com.talentservice.utils;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonBuilder {

	public static JsonBuilder getInstance() {
		return JsonHolder.JSON_BUILDER;
	}
	/**
	 * �ڲ���̬������ʵ����
	 * 
	 * @author YUNFENCGHENG 2011-8-30 ����03:48:07
	 */
	private static class JsonHolder {
		private static final JsonBuilder JSON_BUILDER = new JsonBuilder();
		private static ObjectMapper mapper = new ObjectMapper();
		private static String EMPTY_JSON = "{}";
	}
	/**
	 * ��һ�����ʵ�崫ΪJson��ݸ�ʽ
	 * @param obj
	 * @return
	 */
	public String toJson(Object obj) {
		try {
			return JsonHolder.mapper.writeValueAsString(obj);
		} catch (Exception e) {
			return "";
		}
		
	}
	/**
	 * ��һ��Json�ַ��װΪָ�����Ͷ���
	 * @param json
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object fromJson(String json, Class c) {
		json = cleanJson(json);
		try {
			Object obj = JsonHolder.mapper.readValue(json, c);
			
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * ��һ��JsonArray
	 * @param json
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> fromJsonArray(String json) {
		json = cleanJson(json);
		List<Map> dataList = (List<Map>) fromJson(json, ArrayList.class);
		
		return dataList;
	}
	/**
	 * Ϊ�����ɹ�����Json {success : true, obj : obj}
	 * 
	 * @param obj
	 * @return
	 */
	public String returnSuccessJson(String strData) {
		StringBuffer returnJson = new StringBuffer("{ success : true, obj : ");
		returnJson.append(strData);
		returnJson.append("}");
		return returnJson.toString();
	}
	/**
	 * Ϊ����ʧ�ܷ���Json {success : true, obj : obj}
	 * 
	 * @param obj
	 * @return
	 */
	public String returnFailureJson(String strData) {
		StringBuffer returnJson = new StringBuffer("{ success : false, obj : ");
		returnJson.append(strData);
		returnJson.append("}");
		return returnJson.toString();
	}
	/**
	 * Ϊ��ҳ�б��ṩJson��װ
	 * 
	 * @param count
	 *            ��¼����
	 * @param entities
	 *            ʵ���б�
	 * @param excludes
	 *            ��json���ʱ��Ҫ�ų���������
	 * @return
	 */
	public String buildObjListToJson(Long count, Collection<? extends Object> records, boolean listJson) {
		try {
			StringBuffer pageJson = null;
			if (listJson) {
				pageJson = new StringBuffer("{total:" + count + ","
						+ "rows" + ":");
			} else {
				pageJson = new StringBuffer("");
			}
			// ���л�������
			// MAP�е�key����Ӧ��valueΪnull�򲻲���json���
//			logger.debug("into buildPageJson...");
			
			StringWriter w = new StringWriter();
			JsonHolder.mapper.writeValue(w, records);
			pageJson.append(w);
			w.close();
			
			if (listJson) {
				pageJson.append("}");
			} else {
				pageJson.append("");
			}

//			logger.debug("buildPageJson end, pageJson is : " + pageJson.toString());
			return pageJson.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	private String cleanJson(String json) {
		if(null!=json && "".equals(json)) {
			return json.replaceAll("\n", "").trim();
		}
		return "";
		
	}
	/**
	 * ��jsonSqlStringת����һ����װ����SQL��json����
	 * 
	 * @param sql
	 * @return
	 */
	public String[] jsonSqlToString(String jsonSql) {
		Object[] os = JSONArray.fromObject(jsonSql).toArray();
		String[] sqls = new String[os.length];
		for (int i = 0; i < os.length; i++) {
			JSONObject k = (JSONObject) os[i];
			String kk = (String) k.get("sql");
			sqls[i] = kk;
		}
		return sqls;
	}
}
