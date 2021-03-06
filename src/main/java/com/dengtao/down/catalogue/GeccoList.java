package com.dengtao.down.catalogue;

import com.dengtao.down.bean.FactionCatalogue;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * matchUrl是爬取相匹配的url路径，然后将获取到的HtmlBean输出到相应的管道（pipelines）进行处理。这里的管道是可以自定义的。
 *
 * @author dt
 */
@Gecco(matchUrl = "http://www.xbiquge.la/{?}/{?}/", pipelines = {"consolePipeline", "GeccoListPipeline"})
public class GeccoList implements HtmlBean {

    private static final long serialVersionUID = 1225018257932399804L;

    @Request
    private HttpRequest request;

    /**
     * 首页中的明星板块的集合，li的集合
     * /@HtmlField(cssPath = "#dataListInner > ul >li")是用来抓取网页中的相应网页数据，csspath是jQuery的形式。
     * cssPath获取小技巧：用Chrome浏览器打开需要抓取的网页，按F12进入发者模式。然后在浏览器右侧选中该元素，鼠标右键选择Copy–Copy selector，即可获得该元素的cssPath
     */
    @HtmlField(cssPath = "#list > dl > dd")
    private List<FactionCatalogue> factionCatalogues;

    /**
     * 封面图片
     */
    @Html
    @HtmlField(cssPath ="#fmimg")
    private String  coverImg;

    /**
     * 小说名
     */
    @Text
    @HtmlField(cssPath = "#info > h1")
    private  String factionName;

    /**
     * 作者
     */
    @Text
    @HtmlField(cssPath = "#info > p:nth-child(2)")
    private  String factionUser;

    /**
     * 分类 #wrapper > div:nth-child(6) > div.con_top > a:nth-child(3)
     */
    @Html
    @HtmlField(cssPath = "#wrapper > div:nth-child(5) > div.con_top > a:nth-child(3)")
    private  String factionClassify;

    /**
     * 最后跟新时间
     */
    @Text
    @HtmlField(cssPath = "#info > p:nth-child(4)")
    private String lastTime;

    /**
     * 简介
     */
    @Text
    @HtmlField(cssPath = "#intro > p:nth-child(2)")
    private String synopsis;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public String getFactionUser() {
        return factionUser;
    }

    public void setFactionUser(String factionUser) {
        this.factionUser = factionUser;
    }

    public String getFactionClassify() {
        return factionClassify;
    }

    public void setFactionClassify(String factionClassify) {
        this.factionClassify = factionClassify;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<FactionCatalogue> getFactionCatalogues() {
        return factionCatalogues;
    }

    public void setFactionCatalogues(List<FactionCatalogue> factionCatalogues) {
        this.factionCatalogues = factionCatalogues;
    }
}