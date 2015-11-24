package com.talentservice.lucene;
import java.io.File;
import java.io.IOException;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/** 
 * 搜索索引 Lucene 3.0+ 
 *  
 * @author Administrator 
 *  
 */  
public class Searcher {  
  
   /* public static void search(String indexDir) throws IOException, ParseException {  
        Directory dir = FSDirectory.getDirectory(new File(indexDir));  
        // 创建 IndexSearcher对象，相比IndexWriter对象，这个参数就要提供一个索引的目录就行了  
        IndexSearcher indexSearch = new IndexSearcher(dir);  
        // 创建QueryParser对象,第一个参数表示Lucene的版本,第二个表示搜索Field的字段,第三个表示搜索使用分词器  
        QueryParser queryParser = new QueryParser("filename",new PaodingAnalyzer());  
        // 生成Query对象  
        Query query = queryParser.parse("滑移装载机");  
        // 搜索结果 TopDocs里面有scoreDocs[]数组，里面保存着索引值  
        //TopDocs hits = indexSearch.search(query, 10);  
        Hits hits = indexSearch.search(query);  
        // hits.totalHits表示一共搜到多少个  
        System.out.println("找到了" + hits.length() + "个");  
        // 循环hits.scoreDocs数据，并使用indexSearch.doc方法把Document还原，再拿出对应的字段的值  
        Document doc = null;  
        for(int i=0;i<hits.length();i++){  
            doc = hits.doc(i);  
            System.out.print(doc.get("filename"));  
        }  
        indexSearch.close();  
    }  */
}  
