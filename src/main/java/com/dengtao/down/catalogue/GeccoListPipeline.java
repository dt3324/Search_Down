package com.dengtao.down.catalogue;

import com.dengtao.down.application.MongoClient;
import com.dengtao.down.bean.FictionCatalogue;
import com.dengtao.down.util.DownImage;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.jsoup.Jsoup;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * /@pipelineName 标签指定了pipline的名字。并且pipeline这个类需要实现Pipleline<T>。
 * @author dt
 */
@PipelineName("starIndexPagePipeline")
public class GeccoListPipeline implements Pipeline<GeccoList> {

    @Override
    public void process(GeccoList geccoList) {

        List<FictionCatalogue> fictionCatalogueList = geccoList.getFictionCatalogues();

        //小说详情入库
        String imgHtml = geccoList.getCoverImg();
        //通过解析html标签获取需要的元素
        String coverImg = Jsoup.parse(imgHtml).body().getElementsByTag("img").get(0).attributes().get("src");
        String s = DownImage.saveToFile(coverImg);

        //<p>最后更新：2019-11-12 20:00:00</p>
        String lastTime = geccoList.getLastTime().substring(5,15);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(lastTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //判断 当 最后更新时间超过当前时间一个月为已完结
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        Date newDate = cal.getTime();
        Date nowDate = new Date();
        String isEnd = "连载";
        if(nowDate.compareTo(newDate)>0){
            isEnd = "完结";
        }

        Document document = new Document();
        document.append("coverImg", s);
        document.append("fictionName", geccoList.getFictionName());
        document.append("fictionUser", geccoList.getFictionUser());
        document.append("fictionClassify", geccoList.getFictionClassify());
        document.append("isEnd", isEnd);
        document.append("synopsis", geccoList.getSynopsis());
        MongoClient.getFictionDetailClient().insertOne(document);

        //小说章节目录入库
        ArrayList<Document> documents = new ArrayList<>();
        for (FictionCatalogue fictionCatalogue : fictionCatalogueList) {
            Document document1 = fictionCatalogue.getDocument();
            document1.append("fictionName", geccoList.getFictionName());
            document1.append("fictionUser", geccoList.getFictionUser());
            documents.add(document1);
        }
        MongoClient.getFictionCatalogueClient().insertMany(documents);
    }
}