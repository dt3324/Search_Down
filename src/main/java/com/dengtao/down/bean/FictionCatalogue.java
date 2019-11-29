package com.dengtao.down.bean;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import org.bson.Document;

/**
 * @author dt
 */
public class FictionCatalogue implements HtmlBean {

    /**
     * 章节URL
     */
    @Href
    @HtmlField(cssPath = "dd > a")
    private String chapterUrl;

    @Text
    @HtmlField(cssPath = "dd > a")
    private String chapterName;

    public Document getDocument(){
        Document document = new Document();
        document.append("chapterUrl", this.chapterUrl);
        document.append("chapterName", this.chapterName);
        return document;
    }

    public String getChapterUrl() {
        return chapterUrl;
    }

    public void setChapterUrl(String chapterUrl) {
        this.chapterUrl = chapterUrl;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
}
