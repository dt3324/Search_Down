package com.dengtao.down.content;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * matchUrl是爬取相匹配的url路径，然后将获取到的HtmlBean输出到相应的管道（pipelines）进行处理。这里的管道是可以自定义的。
 *
 * @author dt
 */
@Gecco(matchUrl = "http://www.xbiquge.la/15/15409/{?}.html", pipelines = {"consolePipeline", "starIndexPagePipeline"})
public class GeccoFictionContent implements HtmlBean {

    private static final long serialVersionUID = 1225018257932399804L;

    @Request
    private HttpRequest request;

    /**
     * 小说名
     */
    @Text
    @HtmlField(cssPath = "#wrapper > div.content_read > div > div.con_top > a:nth-child(4)")
    private  String fictionName;

    /**
     * 章节名
     */
    @Text
    @HtmlField(cssPath = "#wrapper > div.content_read > div > div.bookname > h1")
    private String chapterName;

    /**
     * 章节内容
     */
    @Html
    @HtmlField(cssPath = "#content")
    private String chapterContent;


    /**
     * 章节内容
     */
    @Text
    @HtmlField(cssPath = "#content")
    private String chapterSize;

    public String getChapterSize() {
        return chapterSize;
    }

    public void setChapterSize(String chapterSize) {
        this.chapterSize = chapterSize;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getFictionName() {
        return fictionName;
    }

    public void setFictionName(String fictionName) {
        this.fictionName = fictionName;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }
}