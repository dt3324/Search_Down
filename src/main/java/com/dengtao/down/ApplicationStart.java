package com.dengtao.down;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;

/**
 * @author dt
 * /@SpringBootApplication
 */

public class ApplicationStart {
    public static void main(String[] args) {
        //抓取笔趣阁该页面的小说列表
//        GeccoListMain.main("http://www.xbiquge.la/xiaoshuodaquan/");
//获取网站请求
        HttpGetRequest start = new HttpGetRequest("http://www.xbiquge.la/2/2352/");
        start.setCharset("UTF-8");
        //创建搜索引擎
        GeccoEngine.create()
                //要搜索的包名，会自动搜索该包下，含@Gecco注解的文件。
                .classpath("com.dengtao.down")
                .start(start)
                //开启多少个线程抓取
                .thread(5)
                //隔多长时间抓取1次
                .interval(2000)
                .run();
        //通过小说名对应的url获取该小说的章节目录//5ddf87176a7d1b321cc7c310	http://www.xbiquge.la/15/15409/	牧神记
//        FindIterable<Document> factionList = MongoClient.getFactionListClient().find().batchSize(10000);
//        for (Document document : factionList) {
//            String url = document.get("url").toString();
//            GeccoCatalogueMain.main(url);
//            Thread.sleep(8000);
//        }
//
//        FindIterable<Document> factionCatalogue = MongoClient.getFactionCatalogueClient().find().batchSize(10000);
//        for (Document document : factionCatalogue) {
//            String chapterUrl = document.get("chapterUrl").toString();
//            GeccoContentMain.main(chapterUrl);
//        }
    }
}
