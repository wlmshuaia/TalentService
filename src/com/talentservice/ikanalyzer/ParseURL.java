package com.talentservice.ikanalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.xml.ParserException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class ParseURL {
	//索引目录
	private static final String INDEX_DIR = "myindex";
	//已经存在的url列表
	private static List<String> urls=new ArrayList<String>();

	/**
	 * 索引器，对目标url创建索引
	 * @param url	目标网址
	 * @throws IOException
	 * @throws ParserException
	 */
	@SuppressWarnings("deprecation")
	private static void indexer(String url) throws IOException, ParserException {
		//存储索引的目录
		File indexDir = new File(INDEX_DIR);
		//目录不存在，创建该目录
		if (!indexDir.exists()) {
			indexDir.mkdir();
		}
		//获取网页纯文本
		String content = getText(url);
		//获取网页标题
		String title = getTitle(url);

		System.out.println("title:" + title);
		
		if(title==null || content==null || content.trim().equals(""))
		{
			return;
		}
//		System.out.println("content:" + content);
//		URL path=new URL(url);
//		InputStream stream=path.openStream();
//		
//		Reader reader=new InputStreamReader(stream);
		
//		Reader reader=new InputStreamReader(new ByteArrayInputStream(content.getBytes()));
//		Reader reader2=new InputStreamReader(new ByteArrayInputStream(title.getBytes()));
		
		Document doc = new Document();
		//加入url域
		doc.add(new Field("url", url, Field.Store.YES,
						Field.Index.NOT_ANALYZED));
		//加入标题域
		doc.add(new Field("title", title, Field.Store.YES,
				Field.Index.ANALYZED));
//		doc.add(new Field("title",reader2));
		//Index.ANALYZED分词后构建索引
		//加入内容域
		doc.add(new Field("content", content, Field.Store.YES,
				Field.Index.ANALYZED));
//		doc.add(new Field("content",reader));
		
		//创建IKAnalyzer中文分词对象
		Analyzer analyzer=new IKAnalyzer();
		//索引目录
		Directory dir=FSDirectory.open(indexDir);
		//配置IndexWriterConfig
		IndexWriterConfig iwConfig = new IndexWriterConfig(Version.LUCENE_36 , analyzer);
		iwConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
		//创建写索引对象
		IndexWriter writer = new IndexWriter(dir,iwConfig);
		//写入文档
		writer.addDocument(doc);
		//关闭
		writer.close();
		//创建了索引的网址加入到已经存在的网址列表中
		urls.add(url);
	}

	/**
	 * 搜索器，根据输入的文本去搜索
	 * @param words		输入的文本
	 * @param field		搜索的域
	 * @throws CorruptIndexException
	 * @throws IOException
	 * @throws ParseException
	 */
	@SuppressWarnings("deprecation")
	private static void searcher(String words,String field) throws CorruptIndexException,
			IOException, ParseException {
		File indexDir = new File(INDEX_DIR);
		//索引目录
		Directory dir=FSDirectory.open(indexDir);
		//根据索引目录创建读索引对象
		IndexReader reader = IndexReader.open(dir);
		//搜索对象创建
		IndexSearcher searcher = new IndexSearcher(reader);
		//IKAnalyzer中文分词
		Analyzer analyzer = new IKAnalyzer();
		//创建查询解析对象
		QueryParser parser = new QueryParser(Version.LUCENE_36,field, analyzer);
		parser.setDefaultOperator(QueryParser.AND_OPERATOR);
		//根据域和目标搜索文本创建查询器
		Query query = parser.parse(words);
		System.out.println("Searching for: " + query.toString(field));
		//对结果进行相似度打分排序
		TopScoreDocCollector collector = TopScoreDocCollector.create(5 * 10,false);
		searcher.search(query, collector);
		//获取结果
		ScoreDoc[] hits = collector.topDocs().scoreDocs;

		int numTotalHits = collector.getTotalHits();

		System.out.println(numTotalHits + " total matching pages");
		//显示搜索结果
		for (int i = 0; i < hits.length; i++) {
			Document doc = searcher.doc(hits[i].doc);
			String url = doc.get("url");
			String title=doc.get("title");
			String content=doc.get("content");
			
			System.out.println((i + 1) + "." + title);
			System.out.println("-----------------------------------");
			System.out.println(content.substring(0,100)+"......");
			System.out.println("-----------------------------------");
			System.out.println(url);
			System.out.println();
		}
	}

	/**
	 * 收入网站
	 * @param url	网站首页url，也可以为网站地图url
	 * @throws ParserException
	 * @throws IOException
	 * @throws ParseException
	 */
	private static void addSite(String url) throws ParserException, IOException, ParseException
	{
		long start=System.currentTimeMillis();
		System.out.println("start add...");
		//获取目标网页的所有链接
		List<String> links = getLinks(url);
		System.out.println("url count:"+links.size());
		for(int i=0;i<links.size();i++)
		{
			String link=links.get(i);
			System.out.println((i+1)+"."+link);
			
			if(!urls.contains(link))
			{
				//对未创建过索引的网页创建索引
				indexer(link);
			}
			else
			{
				System.out.println("["+link+"] exist");
			}
		}
		
		System.out.println("end...");
		
		long end=System.currentTimeMillis();
		
		System.out.println("cost "+(end-start)/1000+" seconds");
	}
	/**
	 * 获取网页纯文本
	 * @param url	目标网址
	 * @return
	 * @throws ParserException
	 */
	private static String getText(String url) throws ParserException {
		/*StringBean sb = new StringBean();

		// 设置不需要得到页面所包含的链接信息
		sb.setLinks(false);
		// 设置将不间断空格由正规空格所替代
		sb.setReplaceNonBreakingSpaces(true);
		// 设置将一序列空格由一个单一空格所代替
		sb.setCollapse(true);
		// 传入要解析的URL
		sb.setURL(url);
		// 返回解析后的网页纯文本信息
		String content = sb.getStrings();
		// System.out.println(content);
*/		return "";
	}

	/**
	 * 获取网页标题
	 * @param path
	 * @return
	 * @throws IOException
	 * @throws ParserException
	 */
	private static String getTitle(String path) throws IOException, ParserException {
		/*String title = "";
		try {
			
			Parser parser=new Parser(path);
			
			HtmlPage page = new HtmlPage(parser);  
	        parser.visitAllNodesWith(page); 
	        title=page.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			title = "no title";
		}
*/
		return "";
	}

	/**
	 * 获取网页中所有的链接
	 * @param url
	 * @return
	 * @throws ParserException
	 */
	private static List<String> getLinks(String url) throws ParserException {
		/*List<String> links=new ArrayList<String>();
		//创建链接节点的过滤器
		NodeFilter filter = new NodeClassFilter(LinkTag.class);  
		Parser parser = new Parser();  
		parser.setURL(url);
		//设置目标网页的编码方式
		//parser.setEncoding("utf-8");
		//因为有些时候不清楚目标网页的编码方式，这里我们采用指定一
		//个编码集合，然后通过试探的方式得到目标网页的编码方式
		parser.setEncoding(CharsetAutoSwitch.dectedEncode(url));  
		NodeList list = parser.extractAllNodesThatMatch(filter);  
		for (int i = 0; i < list.size(); i++) {  
			LinkTag node = (LinkTag) list.elementAt(i);
			//获取链接的目标网址
			String link=node.extractLink();
			if(link!=null && !link.trim().equals("") && !link.equals("#"))
			{
				//将目标网址加入到该页面的所有网址列表中
				links.add(link);  
			}
		}
		
		return links;*/
		return null;
	}
	
	public static void main(String[] args) throws IOException, ParseException, InterruptedException, ParserException {
		String url = "http://www.csdn.net/";
		//收录网站
		addSite(url);
		//搜有标题带有“搜索引擎”字眼的网页
		searcher("搜索引擎","title");
	}
	
}