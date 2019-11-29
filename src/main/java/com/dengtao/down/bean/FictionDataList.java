package com.dengtao.down.bean;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import org.bson.Document;

/**
 * @author dt
 */
public class FictionDataList implements HtmlBean {

    /**
     * 封面图片
     */
    @Href
    @HtmlField(cssPath ="#fmimg > img")
    private String  coverImg;

    /**
     * 小说名
     */
    @Text
    @HtmlField(cssPath = "#info > h1")
    private  String fictionName;

    /**
     * 作者
     */
    @Text
    @HtmlField(cssPath = "#info > p:nth-child(2)")
    private  String fictionUser;

    /**
     * 分类
     */
    @Text
    @HtmlField(cssPath = "#wrapper > div:nth-child(6) > div.con_top > a:nth-child(3)")
    private  String fictionClassify;

    /**
     * 完结
     */
    @Text
    @HtmlField(cssPath = "#fmimg > span")
    private String isEnd;

    /**
     * 简介
     */
    @Text
    @HtmlField(cssPath = "#intro > p:nth-child(2)")
    private String synopsis;

    /**
     * 字数
     */
    @Text
    @HtmlField(cssPath = "li > div.book-mid-info > p.update > span > span")
    private String numberTotal;

    public Document getDocument(){
        Document document = new Document();
        document.put("coverImg", this.coverImg);
        document.put("fictionUser", this.fictionUser);
        document.put("fictionName", this.fictionName);
        document.put("fictionClassify", this.fictionClassify);
        document.put("isEnd", this.isEnd);
        document.put("synopsis", this.synopsis);
        document.put("numberTotal", this.numberTotal);
        return document;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getFictionName() {
        return fictionName;
    }

    public void setFictionName(String fictionName) {
        this.fictionName = fictionName;
    }

    public String getFictionUser() {
        return fictionUser;
    }

    public void setFictionUser(String fictionUser) {
        this.fictionUser = fictionUser;
    }

    public String getFictionClassify() {
        return fictionClassify;
    }

    public void setFictionClassify(String fictionClassify) {
        this.fictionClassify = fictionClassify;
    }

    public String getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(String isEnd) {
        this.isEnd = isEnd;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getNumberTotal() {
        return numberTotal;
    }

    public void setNumberTotal(String numberTotal) {
        this.numberTotal = numberTotal;
    }

}