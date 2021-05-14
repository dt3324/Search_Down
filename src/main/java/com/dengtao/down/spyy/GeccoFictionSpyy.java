package com.dengtao.down.spyy;

import com.dengtao.down.bean.User;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import java.util.List;

/**
 * matchUrl是爬取相匹配的url路径，然后将获取到的HtmlBean输出到相应的管道（pipelines）进行处理。这里的管道是可以自定义的。
 *
 * @author dt
 */
@Data
@Gecco(matchUrl = "https://park.ibaizhe.cn/uppman/park/owner/index.html?ps=100&p=2", pipelines = {"consolePipeline", "starIndexPagePipeline"})
public class GeccoFictionSpyy implements HtmlBean {

    private static final long serialVersionUID = 1225018257932391804L;

    @Request
    private HttpRequest request;

    /**
     * shuju
     */
    @HtmlField(cssPath = "body > div.container-fluid.pt20 > div.panel.panel-default > table > tbody")
    private List<User> users;


}