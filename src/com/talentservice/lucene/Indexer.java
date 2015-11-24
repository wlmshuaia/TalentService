package com.talentservice.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Date;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer {
	 /** 
     * @param args 
     * @throws IOException 
     */  
   /* public static void index(String dateDir, String indexDir) throws IOException {  
        IndexWriter indexWriter = null;  
        // 创建Directory对象  
        Directory dir = FSDirectory.open(new File(indexDir));
        // 创建IndexWriter对象,第一个参数是Directory,第二个是分词器,第三个表示是否是创建,如果为false为在此基础上面修改,第四表示表示分词的最大值，比如说new  
        // MaxFieldLength(2)，就表示两个字一分，一般用IndexWriter.MaxFieldLength.LIMITED
        indexWriter = new IndexWriter(dir, new PaodingAnalyzer());  
        File[] files = new File(dateDir).listFiles();  
        for (int i = 0; i < files.length; i++) {  
            Document doc = new Document();  
            // 创建Field对象，并放入doc对象中  
            doc.add(new Field("contents", readContents(files[i], "UTF-8"),  
                    Field.Store.YES, Field.Index.UN_TOKENIZED));  
            doc.add(new Field("filename", files[i].getName(), Field.Store.YES,  
                    Field.Index.TOKENIZED));  
            doc.add(new Field("indexDate", DateTools.dateToString(new Date(),  
                    DateTools.Resolution.DAY), Field.Store.YES,  
                    Field.Index.TOKENIZED));  
            // 写入IndexWriter  
            indexWriter.addDocument(doc);  
        }  
        // 查看IndexWriter里面有多少个索引  
        System.out.println("numDocs:" + indexWriter.numRamDocs());  
        indexWriter.optimize();  
        indexWriter.close();  
    }  
  
    public static String readContents(File file, String charset)  
            throws IOException {  
        BufferedReader reader = new BufferedReader(new InputStreamReader(  
                new FileInputStream(file), charset));  
        String line = new String();  
        String temp = new String();  
  
        while ((line = reader.readLine()) != null) {  
            temp += line;  
        }  
        reader.close();  
        return temp;  
    }  */
}
