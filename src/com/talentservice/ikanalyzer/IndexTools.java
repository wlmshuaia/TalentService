package com.talentservice.ikanalyzer;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
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
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class IndexTools {
    /**
     * 获得indexwriter对象
     * 
     * @param dir
     * @return
     * @throws IOException
     * @throws Exception
     */
    private IndexWriter getIndexWriter(Directory dir, Analyzer analyzer) throws IOException {
        IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_40, analyzer);
        return new IndexWriter(dir, iwc);
    }
    
    /**
     * 关闭indexwriter对象
     * 
     * @throws IOException
     * 
     * @throws Exception
     */
    private void closeWriter(IndexWriter indexWriter) throws IOException {
        if (indexWriter != null) {
            indexWriter.close();
        }
    }
    
    /**
     * 创建索引
     * 
     * @throws InvalidTokenOffsetsException
     */
    public void createIndex() throws InvalidTokenOffsetsException {
        String indexPath = "D://luceneindex"; // 建立索引文件的目录
        // 默认IKAnalyzer()-false:实现最细粒度切分算法,true:分词器采用智能切分
        Analyzer analyzer = new IKAnalyzer(true);
        IndexWriter indexWriter = null;
        Directory directory = null;
        try {
            directory = FSDirectory.open(new File(indexPath));
            indexWriter = getIndexWriter(directory, analyzer);
        } catch (Exception e) {
            System.out.println("索引打开异常！");
        }
        // 添加索引
        try {
            Document document = new Document();
            document.add(new TextField("filename", "标题:起点", Store.YES));
            document.add(new TextField("content", "内容：我是一名程序员", Store.YES));
            indexWriter.addDocument(document);
            Document document1 = new Document();
            document1.add(new TextField("filename", "标题:终点", Store.YES));
            document1.add(new TextField("content", "内容：我不再只是程序员", Store.YES));
            indexWriter.addDocument(document1);
            indexWriter.commit();
        } catch (IOException e1) {
            System.out.println("索引创建异常！");
        }
        try {
            closeWriter(indexWriter);
        } catch (Exception e) {
            System.out.println("索引关闭异常！");
        }
    }
    
    /**
     * 搜索
     * 
     * @throws ParseException
     * @throws IOException
     * @throws InvalidTokenOffsetsException
     */
    @SuppressWarnings("deprecation")
    public void searchIndex() throws ParseException, IOException, InvalidTokenOffsetsException {
        String indexPath = "D://luceneindex"; // 建立索引文件的目录
        // 默认IKAnalyzer()-false:实现最细粒度切分算法,true:分词器采用智能切分
        Analyzer analyzer = new IKAnalyzer(true);
        Directory directory = null;
        try {
            directory = FSDirectory.open(new File(indexPath));
        } catch (Exception e) {
            System.out.println("索引打开异常！");
        }
        IndexReader ireader = null;
        IndexSearcher isearcher = null;
        try {
            ireader = IndexReader.open(directory);
        } catch (IOException e) {
            System.out.println("打开索引文件！");
        }
        isearcher = new IndexSearcher(ireader);
        String keyword = "程序员";
        // 使用QueryParser查询分析器构造Query对象
        // eg:单个字段查询
        // String fieldName = "content";
        // QueryParser qp = new QueryParser(Version.LUCENE_40, fieldName, analyzer);
        String[] fields = { "filename", "content" };
        QueryParser qp = new MultiFieldQueryParser(Version.LUCENE_40, fields, analyzer);
        qp.setDefaultOperator(QueryParser.AND_OPERATOR);
        Query query = qp.parse(keyword);
        // 搜索相似度最高的5条记录
        TopDocs topDocs = isearcher.search(query, 25);
        System.out.println("命中：" + topDocs.totalHits);
        // 输出结果
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (int i = 0; i < topDocs.totalHits; i++) {
            Document targetDoc = isearcher.doc(scoreDocs[i].doc);
            System.out.println("内容：" + targetDoc.toString());
        }
        // 分页，高亮显示
        higherIndex(analyzer, isearcher, query, topDocs);
    }
    
    public static void main(String[] args) {
        IndexTools tool = new IndexTools();
        try {
            tool.searchIndex();
        } catch (ParseException e) {
            System.out.println("解析错误");
        } catch (IOException e) {
            System.out.println("读取文件流错误");
        } catch (InvalidTokenOffsetsException e) {
            System.out.println("查询失败");
        }
    }
    
    /**
     * 分页，高亮显示
     * 
     * @param analyzer
     * @param isearcher
     * @param query
     * @param topDocs
     * @throws IOException
     * @throws InvalidTokenOffsetsException
     */
    public void higherIndex(Analyzer analyzer, IndexSearcher isearcher, Query query, TopDocs topDocs)
            throws IOException, InvalidTokenOffsetsException {
        TopScoreDocCollector results = TopScoreDocCollector.create(topDocs.totalHits, false);
        isearcher.search(query, results);
        // 分页取出指定的doc(开始条数, 取几条)
        ScoreDoc[] docs = results.topDocs(1, 2).scoreDocs;
        for (int i = 0; i < docs.length; i++) {
            Document targetDoc = isearcher.doc(docs[i].doc);
            System.out.println("内容：" + targetDoc.toString());
        }
        // 关键字高亮显示的html标签，需要导入lucene-highlighter-3.5.0.jar
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
        for (int i = 0; i < docs.length; i++) {
            Document doc = isearcher.doc(docs[i].doc);
            // 标题增加高亮显示
            TokenStream tokenStream1 = analyzer.tokenStream("filename", new StringReader(doc.get("filename")));
            String title = highlighter.getBestFragment(tokenStream1, doc.get("filename"));
            // 内容增加高亮显示
            TokenStream tokenStream2 = analyzer.tokenStream("content", new StringReader(doc.get("content")));
            String content = highlighter.getBestFragment(tokenStream2, doc.get("content"));
            System.out.println(doc.get("filename") + " : " + title + " : " + content);
        }
    }
}