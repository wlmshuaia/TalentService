package com.talentservice.ikanalyzer;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.talentservice.domain.Project;

public class IKAnalyzerTest {
	
	//索引目录  
    private static final String INDEX_DIR = "myindex";  
    //已经存在的url列表  
    private static List<String> urls=new ArrayList<String>();
    private Directory directory ;
    private Analyzer analyzer ;
    
    public IKAnalyzerTest(String indexFilePath){
        try {
            directory = FSDirectory.open(new File(indexFilePath));
            analyzer = new IKAnalyzer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
	 //@Test
    /**
     * 创建索引
     * 
     * @throws Exception
     */
     public  void testIKAnalyzer() throws Exception {
		 /*String keyWord = "项目情况： 1.项目为基于php+css+html+jqeury的传统的业务管理系统。 2.项目基本框架已开发完毕，需要完善实际代码。已经基本不需要写html,css，需要的只是后台php和前段jquery。接包方不需要做美工工作，"
		 		+ "不需要做css设计。接包方的主要工作是用PHP和jquery开发剩下功能模块。 团队要求： 1.企业：无限制，只要能按时完工即可。 2.个人：专职的，不接受白天上班，晚上兼职接包方式。谢谢。 其他要求： 1.精通php+jquery。";
		 IKAnalyzer analyzer = new IKAnalyzer();
		 analyzer.setUseSmart(true);
		 System.out.println("分词："+keyWord);
		 try {
			 TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(keyWord));
			 tokenStream.addAttribute(CharTermAttribute.class);
			 tokenStream.reset();//必须先调用reset方法，否则会报下面的错，可以参考TokenStream的API说明
			 System.out.print("结果：");
			 while (tokenStream.incrementToken()) {
				 CharTermAttribute charTermAttribute = (CharTermAttribute) tokenStream.getAttribute(CharTermAttribute.class);
				 System.out.print(charTermAttribute.toString() + "\n");
			 }
			 tokenStream.end();
			 tokenStream.close();
		 } catch(Exception e) {
			 e.printStackTrace();
		 }*/
         
		 IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, analyzer);
		 IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
		 indexWriter.deleteAll();
		 List<Project> list = new ArrayList<Project>();
		 Project p1 = new Project() ;
		 p1.setPid((long)1);
		 p1.setDescription("项目情况： 1.项目为基于php+css+html+jqeury的传统的业务管理系统。 2.项目基本框架已开发完毕，需要完善实际代码。已经基本不需要写html,css，需要的只是后台php和前段jquery。接包方不需要做美工工作，"
		 		+ "不需要做css设计。接包方的主要工作是用PHP和jquery开发剩下功能模块。 团队要求： 1.企业：无限制，只要能按时完工即可。 2.个人：专职的，不接受白天上班，晚上兼职接包方式。谢谢。 其他要求： 1.精通php+jquery。");
		 Project p2 = new Project() ;
		 p2.setPid((long)2);
		 p2.setDescription("专职基于项目发布测试");
		 list.add(p1);
		 list.add(p2);
		 
		 for(int i = 0; i < list.size(); i++){
			 Project project= list.get(i);
			 Document document = addDocument(project.getPid(), project.getDescription());
			 indexWriter.addDocument(document);
		 }
		 indexWriter.close();
     }
     
     /**
      * 
      * Description：添加索引
      * @param id
      * @param title
      * @return
      */
     public  Document addDocument(Long id, String description){
         Document doc = new Document();
         //Field.Index.NO 表示不索引         
         //Field.Index.ANALYZED 表示分词且索引         
         //Field.Index.NOT_ANALYZED 表示不分词且索引
         doc.add(new Field("id", String.valueOf(id),Field.Store.YES,Field.Index.NOT_ANALYZED));
         doc.add(new Field("description", description, Field.Store.YES,Field.Index.ANALYZED));
         return doc;
     }
     
     /**
      * 
      * Description：查询
      * @param where 查询条件
      * @param scoreDoc 分页时用
      */
     public List<Project> search(String[] fields,String keyword){
         
         IndexSearcher indexSearcher = null;
         List<Project> result = new ArrayList<Project>();
         
         try {
             //创建索引搜索器,且只读
             IndexReader indexReader = IndexReader.open(directory);
             indexSearcher = new IndexSearcher(indexReader);

             MultiFieldQueryParser queryParser =new MultiFieldQueryParser(Version.LUCENE_35, fields,analyzer);
             Query query = queryParser.parse(keyword);
             
             //返回前number条记录
             TopDocs topDocs = indexSearcher.search(query, 10);
             //信息展示
             int totalCount = topDocs.totalHits;
             System.out.println("共检索出 "+totalCount+" 条记录");

             /**
              * 高亮显示
              * 
              * 创建高亮器,使搜索的结果高亮显示
              *   SimpleHTMLFormatter：用来控制你要加亮的关键字的高亮方式
              * 此类有2个构造方法
              *   1：SimpleHTMLFormatter()默认的构造方法.加亮方式：<B>关键字</B>
              *   2：SimpleHTMLFormatter(String preTag, String postTag).加亮方式：preTag关键字postTag
              * 
              */
             SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<font color='red'>","</font>");    
             
             /**
              *    QueryScorer 是内置的计分器。计分器的工作首先是将片段排序。QueryScorer使用的项是从用户输入的查询中得到的；
			  *                 它会从原始输入的单词、词组和布尔查询中提取项，并且基于相应的加权因子（boost factor）给它们加权。
			  *                 为了便于QueryScoere使用，还必须对查询的原始形式进行重写。
			  *                 比如，带通配符查询、模糊查询、前缀查询以及范围查询 等，都被重写为BoolenaQuery中所使用的项。
			  *                 在将Query实例传递到QueryScorer之前，可以调用Query.rewrite (IndexReader)方法来重写Query对象 
              */
             Scorer fragmentScorer = new QueryScorer(query);
             Highlighter highlighter = new Highlighter(formatter,fragmentScorer);
             Fragmenter fragmenter = new SimpleFragmenter(100);
             
             /**
              *   Highlighter利用Fragmenter将原始文本分割成多个片段。 内置的SimpleFragmenter将原始文本分割成相同大小的片段，片段默认的大小为100个字符。这个大小是可控制的。
              */
             highlighter.setTextFragmenter(fragmenter);
             
             ScoreDoc[] scoreDocs = topDocs.scoreDocs;
             
             for(ScoreDoc scDoc : scoreDocs){
                 Document  document = indexSearcher.doc(scDoc.doc);
                 String id = document.get("id");
                 System.out.println("id: "+id);
                 String description = document.get("description");
                 //float score = scDoc.score; //相似度
                 
                 String lighterName = highlighter.getBestFragment(analyzer, "description", description);
                 if(null==lighterName){
                     lighterName = description;
                 }
                 
                 Project Project = new Project();
                 
                 Project.setPid(Long.parseLong(id));
                 Project.setDescription(lighterName);
                 
                 result.add(Project);
                             }
         } catch (Exception e) {
             e.printStackTrace();
         }finally{
         }
     
         return result;
     }

	 
	 /**
	  * 获取project列表
	  * 
	  * @return
	  */
	 public String getList(){
		 
		 return null ;
	 }
     
	 public static void main(String[] args) {
		 IKAnalyzerTest luceneProcess = new IKAnalyzerTest("F:/index");
        try {
            luceneProcess.testIKAnalyzer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //查询测试
        String [] fields = {"description","function"};
        List<Project> list = luceneProcess.search(fields, "基于") ;
        for(int i=0; i<list.size(); i++){
            Project Project = list.get(i);
            System.out.println("("+Project.getPid()+")"+Project.getDescription());
        }
        //删除测试
        //luenceProcess.delete(1);
	}
	 
     private void printAnalysisResult(Analyzer analyzer, String keyWord) throws Exception {
         System.out.println("当前使用的分词器：" + analyzer.getClass().getSimpleName());
         TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(keyWord));
         tokenStream.addAttribute(CharTermAttribute.class);
         tokenStream.reset();
         while (tokenStream.incrementToken()) {
             CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
             System.out.println(new String(charTermAttribute.buffer()));
         }
     }
}
