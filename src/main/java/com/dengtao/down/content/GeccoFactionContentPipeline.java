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
@PipelineName("GeccoFactionContent")
public class GeccoFactionContentPipeline implements Pipeline<GeccoFactionContent> {

    @Override
    public void process(GeccoFactionContent geccoFactionContent) {
        //章节内容
        String chapterContent = geccoFactionContent.getChapterContent();
        //章节名
        String chapterName = geccoFactionContent.getChapterName();
        //小说名
        String factionName = geccoFactionContent.getFactionName();
        //本章字数
        int length = geccoFactionContent.getChapterSize().length();
        Document document = new Document();
        document.append("factionName", factionName);
        document.append("chapterName", chapterName);
        document.append("length", length);
        document.append("chapterContent", chapterContent);

        MongoClient.getFictionContentClient().insertOne(document);
    }
}