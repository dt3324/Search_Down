package com.dengtao.down.content;

import com.dengtao.down.application.MongoClient;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 * /@pipelineName 标签指定了pipline的名字。并且pipeline这个类需要实现Pipleline<T>。
 * @author dt
 */
@PipelineName("starIndexPagePipeline")
public class GeccoFictionContentPipeline implements Pipeline<GeccoFictionContent> {

    @Override
    public void process(GeccoFictionContent geccoFictionContent) {
        //章节内容
        String chapterContent = geccoFictionContent.getChapterContent();
        //章节名
        String chapterName = geccoFictionContent.getChapterName();
        //小说名
        String fictionName = geccoFictionContent.getFictionName();
        //本章字数
        int length = geccoFictionContent.getChapterSize().length();
        Document document = new Document();
        document.append("fictionName", fictionName);
        document.append("chapterName", chapterName);
        document.append("length", length);
        document.append("chapterContent", chapterContent);

        MongoClient.getFictionContentClient().insertOne(document);
    }
}