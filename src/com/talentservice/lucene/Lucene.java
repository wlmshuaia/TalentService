package com.talentservice.lucene;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

public class Lucene {
	/*private String searchString;
	private List<searchResult> list = new ArrayList<searchResult>();;

	public List<searchResult> getList() {
		return list;
	}

	public void setList(List<searchResult> list) {
		this.list = list;
	}

	public Lucene() {
	}

	public Lucene(String searchString) {
		this.setSearchString(searchString);
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchString() {
		return searchString;
	}

	// 对于name属性进行全文搜索，返回hits值
	public Hits seacher(String queryString) {
		Hits hits = null;

		try {
			File indexFile = new File("d:/index/");
			IndexReader reader = IndexReader.open(indexFile);
			Analyzer analyzer = new PaodingAnalyzer();
			QueryParser parser = new QueryParser("name", analyzer);
			IndexSearcher searcher = new IndexSearcher(reader);
			Query query = parser.parse(queryString);
			hits = searcher.search(query, 0);

		} catch (Exception e) {
			System.out.print(e);
		}
		return hits;
	}

	// 创建索引
	public void indexCreateUtil() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/rent";
		String user = "root";
		String password = "111111";
		// 查询所有房屋信息放在index索引中
		String query = "select a.house_id,a.house_name,b.house_type_name,house_rent_type_name,a.single_day_price from t_house a,t_house_type b,t_house_rent_type c where a.house_type_id=b.house_type_id and a.house_rent_type_id=c.house_rent_type_id";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("数据库连接成功！");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			Analyzer analyzer = new PaodingAnalyzer();
			try {
				// 使用索引文件夹，庖丁解牛分词器创建IndexWriter
				IndexWriter indexWriter = new IndexWriter("d:/index/", analyzer, true);

				while (rs.next()) {
					Document doc = new Document();
					doc.add(new Field("id", rs.getString("house_id"),
							Field.Store.YES, Field.Index.TOKENIZED,
							Field.TermVector.NO));
					doc.add(new Field("name", rs.getString("house_name"),
							Field.Store.YES, Field.Index.TOKENIZED,
							Field.TermVector.NO));
					doc.add(new Field("type_name", rs
							.getString("house_type_name"), Field.Store.YES,
							Field.Index.TOKENIZED, Field.TermVector.NO));
					doc.add(new Field("rent_name", rs
							.getString("house_rent_type_name"),
							Field.Store.YES, Field.Index.TOKENIZED,
							Field.TermVector.NO));
					doc.add(new Field("price",
							rs.getString("single_day_price"), Field.Store.YES,
							Field.Index.TOKENIZED, Field.TermVector.NO));

					indexWriter.addDocument(doc);
				}
				// 优化
				indexWriter.optimize();
				indexWriter.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 用索引搜索,并加入list
	public List<searchResult> indexSearchUtil(String search) {
		Hits hits = seacher(search);

		for (int i = 0; i < hits.length(); i++) {
			try {
				Document doc = hits.doc(i);
				int id = Integer.parseInt(doc.get("id"));
				String name = doc.get("name");
				String type_name = doc.get("type_name");
				String rent_name = doc.get("rent_name");
				int price = Integer.parseInt(doc.get("price"));
				// System.out.println(id + "" + name + "" + type_name + ""
				// + rent_name + "" + price);

				// List<searchResult> list = new ArrayList<searchResult>();
				searchResult sr = new searchResult();
				sr.setHouse_id(id);
				sr.setHouse_name(name);
				sr.setHouse_rent_name(rent_name);
				sr.setHouse_type_name(type_name);
				sr.setSingle_day_price(price);
				list.add(sr);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return list;
	}*/
}
