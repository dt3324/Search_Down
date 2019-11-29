package com.dengtao.down.list;

import com.dengtao.down.bean.SimpleData;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * matchUrl是爬取相匹配的url路径，然后将获取到的HtmlBean输出到相应的管道（pipelines）进行处理。这里的管道是可以自定义的。
 *
 * @author dt
 */
@Gecco(matchUrl = "http://www.xbiquge.la/xiaoshuodaquan/", pipelines = {"consolePipeline", "starIndexPagePipeline"})
public class GeccoFictionList implements HtmlBean {

    private static final long serialVersionUID = 1225018257932399804L;

    @Request
    private HttpRequest request;

    /**
     * url中的page参数
     */
    @RequestParameter
    private String page;

    /**
     * 首页中的明星板块的集合，li的集合
     * /@HtmlField(cssPath = "#dataListInner > ul >li")是用来抓取网页中的相应网页数据，csspath是jQuery的形式。
     * cssPath获取小技巧：用Chrome浏览器打开需要抓取的网页，按F12进入发者模式。然后在浏览器右侧选中该元素，鼠标右键选择Copy–Copy selector，即可获得该元素的cssPath
     */
    @HtmlField(cssPath = "#main > div:nth-child(1) > ul > li")
    private List<SimpleData> XHList;

    /**
     * 武侠 仙侠 修真类
     */
    @HtmlField(cssPath = "#main > div:nth-child(3) > ul > li")
    private List<SimpleData> WXList;

    /**
     * 言情 都市
     */
    @HtmlField(cssPath = "#main > div:nth-child(5) > ul>li")
    private List<SimpleData> YQList;

    /**
     * 历史 军事 穿越
     */
    @HtmlField(cssPath = "#main > div:nth-child(7) > ul>li")
    private List<SimpleData> LSList;

    /**
     * 游戏 竞技 网游
     */
    @HtmlField(cssPath = "#main > div:nth-child(9) > ul>li")
    private List<SimpleData> YXList;

    /**
     * 灵异 科幻
     */
    @HtmlField(cssPath = "#main > div:nth-child(11) > ul>li")
    private List<SimpleData> KHList;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<SimpleData> getXHList() {
        return XHList;
    }

    public void setXHList(List<SimpleData> XHList) {
        this.XHList = XHList;
    }

    public List<SimpleData> getWXList() {
        return WXList;
    }

    public void setWXList(List<SimpleData> WXList) {
        this.WXList = WXList;
    }

    public List<SimpleData> getYQList() {
        return YQList;
    }

    public void setYQList(List<SimpleData> YQList) {
        this.YQList = YQList;
    }

    public List<SimpleData> getLSList() {
        return LSList;
    }

    public void setLSList(List<SimpleData> LSList) {
        this.LSList = LSList;
    }

    public List<SimpleData> getYXList() {
        return YXList;
    }

    public void setYXList(List<SimpleData> YXList) {
        this.YXList = YXList;
    }

    public List<SimpleData> getKHList() {
        return KHList;
    }

    public void setKHList(List<SimpleData> KHList) {
        this.KHList = KHList;
    }
}