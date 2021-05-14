package com.dengtao.down;

import com.dengtao.down.spyy.GeccoSpyyMain;

/**
 * @author dt
 * /@SpringBootApplication
 */

public class ApplicationStart {
    public static void main(String[] args) throws InterruptedException {
        //抓取笔趣阁该页面的小说列表
        GeccoSpyyMain.main("https://park.ibaizhe.cn/uppman/park/owner/index.html?sp_provice=0&sp_city=0&sp_county=0&sp_park_name=&sp_park_id=0&sp_keywords=&sp_otype_id=0&sp_create_start_time=&sp_create_end_time=&sp_start_time=&sp_end_time=&sp_state=all&sp_issue_admin_name=&sp_issue_admin_id=0");

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
