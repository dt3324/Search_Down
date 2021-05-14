package com.dengtao.down;

import com.dengtao.down.spyy.GeccoSpyyMain;

/**
 * @author dt
 * /@SpringBootApplication
 */

public class ApplicationStart {
    public static void main(String[] args) throws InterruptedException {
        //抓取笔趣阁该页面的小说列表
        GeccoSpyyMain.main("https://park.ibaizhe.cn/uppman/park/owner/index.html?ps=100&p=2");

        //通过小说名对应的url获取该小说的章节目录//5ddf87176a7d1b321cc7c310	http://www.xbiquge.la/15/15409/	牧神记
//        FindIterable<Document> fictionList = MongoClient.getFictionListClient().find().batchSize(10000);
//        for (Document document : fictionList) {
//            String url = document.get("url").toString();
//            GeccoCatalogueMain.main(url);
//            Thread.sleep(8000);
//        }
//
//        FindIterable<Document> fictionCatalogue = MongoClient.getFictionCatalogueClient().find().batchSize(10000);
//        for (Document document : fictionCatalogue) {
//            String chapterUrl = document.get("chapterUrl").toString();
//            GeccoContentMain.main(chapterUrl);
//        }
    }
}
