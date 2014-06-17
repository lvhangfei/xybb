package com.xybb.lucene;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import com.xybb.system.parameter.SystemParameter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * Created by lw on 14-6-18.
 */
public class Indexer {

    //保存索引文件的地方
    private static String INDEX_DIR = SystemParameter.FILE_SEPARATOR + "data" +
            SystemParameter.FILE_SEPARATOR + "lucene" + SystemParameter.FILE_SEPARATOR + "index";
    //将要搜索TXT文件的地方
    private static String DATA_DIR = SystemParameter.FILE_SEPARATOR + "data" +
            SystemParameter.FILE_SEPARATOR + "lucene" + SystemParameter.FILE_SEPARATOR + "search";

    public static void main(String[] args) throws Exception {
        long start = new Date().getTime();
        int numIndexed = index(new File(INDEX_DIR), new File(DATA_DIR));
        long end = new Date().getTime();

        System.out.println("Indexing " + numIndexed + " files took "
                + (end - start) + " milliseconds");
    }

    /**
     * 索引dataDir下.txt文件，并储存在indexDir下，返回索引的文件数量
     *
     * @param indexDir
     * @param dataDir
     * @return
     * @throws IOException
     */
    public static int index(File indexDir, File dataDir) throws IOException {
        if (!dataDir.exists() || !dataDir.isDirectory()) {
            throw new IOException(dataDir
                    + " does not exist or is not a directory");
        }
        /**
         * 创建IndexWriter对象,
         * 第一个参数是Directory,也可以为：Directory dir = new SimpleFSDirectory(new File(indexDir));
         * 第二个是分词器,
         * 第三个表示是否是创建,
         * 如果为false为在此基础上面修改,
         * 第四表示表示分词的最大值，比如说new MaxFieldLength(2)，
         * 就表示两个字一分，一般用IndexWriter.MaxFieldLength.LIMITED
         *
         */
        IndexWriter writer = new IndexWriter(FSDirectory.open(indexDir),
                new StandardAnalyzer(Version.LUCENE_30), true,
                IndexWriter.MaxFieldLength.LIMITED);
        indexDirectory(writer, dataDir);

        //查看IndexWriter里面有多少个索引
        int numIndexed = writer.numDocs();
        writer.optimize();
        writer.close();
        return numIndexed;
    }

    /**
     * 循环遍历dir下的所有.txt文件并进行索引
     *
     * @param writer
     * @param dir
     * @throws IOException
     */
    private static void indexDirectory(IndexWriter writer, File dir)
            throws IOException {

        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                //递归
                indexDirectory(writer, files[i]);
            } else if (files[i].getName().endsWith(".txt")) {
                indexFile(writer, files[i]);
            }
        }
    }

    /**
     * 对单个txt文件进行索引
     *
     * @param writer
     * @param f
     * @throws IOException
     */
    private static void indexFile(IndexWriter writer, File f)
            throws IOException {

        if (f.isHidden() || !f.exists() || !f.canRead()) {
            return;
        }

        System.out.println("Indexing " + f.getCanonicalPath());
        Document doc = new Document();
        doc.add(new Field("contents", new FileReader(f)));
        doc.add(new Field("filename", f.getCanonicalPath(), Field.Store.YES, Field.Index.ANALYZED));

        /**
         * Field.Index有五个属性，分别是：
         * Field.Index.ANALYZED：分词索引
         * Field.Index.NOT_ANALYZED：分词进行索引，如作者名，日期等，Rod Johnson本身为一单词，不再需要分词。
         * Field.Index.NO：不进行索引，存放不能被搜索的内容如文档的一些附加属性如文档类型, URL等。
         * Field.Index.NOT_ANALYZED_NO_NORMS：不使用分词索引，不使用存储规则。
         * Field.Index.ANALYZED_NO_NORMS：使用分词索引，不使用存储规则。
         */
        writer.addDocument(doc);
    }
}
