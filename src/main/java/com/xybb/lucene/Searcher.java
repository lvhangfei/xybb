package com.xybb.lucene;


import java.io.File;
import java.util.Date;

import com.xybb.system.parameter.SystemParameter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * Created by lw on 14-6-18.
 */

public class Searcher {

    //保存索引的地方
    private static String INDEX_DIR = SystemParameter.FILE_SEPARATOR + "data" +
            SystemParameter.FILE_SEPARATOR + "lucene" + SystemParameter.FILE_SEPARATOR + "index";

    private static String KEYWORD = "李伟";
    private static int TOP_NUM = 100;

    public static void main(String[] args) throws Exception {
        File indexDir = new File(INDEX_DIR);
        if (!indexDir.exists() || !indexDir.isDirectory()) {
            throw new Exception(indexDir
                    + " does not exist or is not a directory.");
        }

        search(indexDir, KEYWORD);
    }

    /**
     * 查詢
     *
     * @param indexDir 索引目录地址
     * @param q        要查询的字符串
     * @throws Exception
     */
    public static void search(File indexDir, String q) throws Exception {

        //创建 IndexSearcher对象，相比IndexWriter对象，这个参数就要提供一个索引的目录就行了
        IndexSearcher indexSearch = new IndexSearcher(FSDirectory.open(indexDir), true);// read-only
        //在建立索引时,存在IndexWriter对象中的
        String field = "contents";

        /**
         *  创建QueryParser对象,
         *  第一个参数表示Lucene的版本,
         *  第二个表示搜索Field的字段,
         *  第三个表示搜索使用分词器
         */
        QueryParser parser = new QueryParser(Version.LUCENE_30, field, new StandardAnalyzer(Version.LUCENE_30));

        //生成Query对象
        Query query = parser.parse(q);

        TopScoreDocCollector collector = TopScoreDocCollector.create(TOP_NUM, false);

        // start time
        long start = new Date().getTime();

        indexSearch.search(query, collector);
        //搜索结果TopScoreDocCollector里面有 TopDocs,TopDocs里面有scoreDocs[]数组，里面保存着索引值.
        ScoreDoc[] hits = collector.topDocs().scoreDocs;

        System.out.println("找到了" + hits.length + "个");

        //循环ScoreDoc数据，并使用indexSearch.doc方法把Document还原，再拿出对应的字段的值
        for (int i = 0; i < hits.length; i++) {
            // new method is.doc()
            Document doc = indexSearch.doc(hits[i].doc);
            System.out.println(doc.getField("filename") + "------------" + hits[i].toString());
        }
        indexSearch.close();

        // end time
        long end = new Date().getTime();

        System.out.println("Found " + collector.getTotalHits()
                + " document(s) (in " + (end - start)
                + " milliseconds) that matched query '" + q + "':");

    }
}
