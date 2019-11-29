package com.dengtao.down.bean;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import org.bson.Document;

/**
 * @author dt
 */
public class SimpleData  implements HtmlBean {

    @Href
    @HtmlField(cssPath = "li > a")
    private String url;
    @Text
    @HtmlField(cssPath = "li > a")
    private String fictionName;

    public Document getDocument(){
        Document document = new Document();
        document.append("url", this.url);
        document.append("fictionName", this.fictionName);
        return document;
    }
    public String getFictionName() {
        return fictionName;
    }

    public void setFictionName(String fictionName) {
        this.fictionName = fictionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
