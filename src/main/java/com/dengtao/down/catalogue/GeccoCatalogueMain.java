package com.dengtao.down.catalogue;

import com.dengtao.down.application.MongoClient;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.mongodb.client.FindIterable;
import org.apache.tools.ant.taskdefs.Sleep;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;

/**
 * 从笔趣阁抓取小说目录
 *
 * @author dt
 */
public class GeccoCatalogueMain {
    public static void main(String url){
        //获取网站请求
        HttpGetRequest start = new HttpGetRequest(url);
        start.setCharset("UTF-8");
        //创建搜索引擎
        GeccoEngine.create()
                //要搜索的包名，会自动搜索该包下，含@Gecco注解的文件。
                .classpath("com.dengtao.down.catalogue")
                .start(start)
                //开启多少个线程抓取
                .thread(50)
                //隔多长时间抓取1次
                .interval(2000)
                .run();
    }
}