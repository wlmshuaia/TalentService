package com.talentservice.ikanalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.talentservice.domain.Project;
import com.talentservice.utils.DataUtils;

public class LuceneDao {
	//索引目录  
    private static final String INDEX_DIR = "myindex";  
    //已经存在的url列表  
    private static List<String> urls=new ArrayList<String>();
    private Directory directory ;
    private Analyzer analyzer ;
    
    public LuceneDao(String indexFilePath){
        try {
            directory = FSDirectory.open(new File(indexFilePath));
            analyzer = new IKAnalyzer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建索引
     * 
     * @throws Exception
     */
     public  void createIndex(List<Project> list) throws Exception {
		 IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, analyzer);
		 IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
		 indexWriter.deleteAll();
		 
		 for(int i = 0; i < list.size(); i++){
			 Project project= list.get(i);
			 Document document = addDocument(project);
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
     public  Document addDocument(Project p){
         Document doc = new Document();
         //Field.Index.NO 表示不索引         
         //Field.Index.ANALYZED 表示分词且索引         
         //Field.Index.NOT_ANALYZED 表示不分词且索引
         doc.add(new Field("id", String.valueOf(p.getPid()),Field.Store.YES,Field.Index.NOT_ANALYZED));
         doc.add(new Field("title", p.getTitle(), Field.Store.YES,Field.Index.ANALYZED));
         doc.add(new Field("description", p.getDescription(), Field.Store.YES,Field.Index.ANALYZED));
         return doc;
     }
     
     /**
      * 
      * Description：查询
      * @param where 查询条件
      * @param scoreDoc 分页时用
      */
     public Map<String, Object> search(String[] fields,String keyword){
         IndexSearcher indexSearcher = null;
         List<Project> result = new ArrayList<Project>();
         int totalCount = 0 ;
         try {
             //创建索引搜索器,且只读
             IndexReader indexReader = IndexReader.open(directory);
             indexSearcher = new IndexSearcher(indexReader);

             MultiFieldQueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_35, fields,analyzer);
             Query query = queryParser.parse(keyword);
             
             //返回前number条记录
             TopDocs topDocs = indexSearcher.search(query, DataUtils.DATA_NUM);
             //信息展示
             totalCount = topDocs.totalHits;
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
                 // ID
                 String id = document.get("id");
                 System.out.println("id: "+id);
                 
                 // 标题  ==> 高亮显示
                 String title = document.get("title") ;
                 String lighterTitle = highlighter.getBestFragment(analyzer, "title", title);
                 if(null == lighterTitle){
                	 lighterTitle = title;
                 }
                 
                 // 描述 ==> 高亮显示
                 String description = document.get("description");
                 //float score = scDoc.score; //相似度
                 
                 String lighterName = highlighter.getBestFragment(analyzer, "description", description);
                 if(null==lighterName){
                     lighterName = description;
                 }
                 
                 Project Project = new Project();
                 
                 Project.setPid(Long.parseLong(id));
                 Project.setTitle(lighterTitle);
                 Project.setDescription(lighterName);
                 
                 result.add(Project);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         Map<String, Object> val = new HashMap<String, Object>() ;
         val.put("count", totalCount);
         val.put("result", result) ;
         
         return val;
     }
}
