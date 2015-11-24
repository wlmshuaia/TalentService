package com.talentservice.ikanalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

public class MySearcher {
	public static List<String> searchIndex(String keyword, String indexPath) throws IOException, ParseException{
		List<String> result = new ArrayList<>();
		IndexSearcher indexSearcher = null;
		IndexReader indexReader = DirectoryReader.open(FSDirectory.open(new File(indexPath)));
		indexSearcher = new IndexSearcher(indexReader);
		Analyzer analyzer = new WhitespaceAnalyzer();
		
		QueryParser queryParser = new QueryParser("title", analyzer);
		Query query = queryParser.parse(keyword);
		TopDocs td = indexSearcher.search(query, 10);
		for (int i = 0; i < td.totalHits; i++) {
			Document document = indexSearcher.doc(td.scoreDocs[i].doc);
			result.add(document.get("title"));
		}
		return result;
	}
}
