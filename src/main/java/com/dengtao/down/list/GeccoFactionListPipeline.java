package com.dengtao.down.list;

import com.dengtao.down.application.MongoClient;
import com.dengtao.down.bean.SimpleData;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * /@pipelineName 标签指定了pipline的名字。并且pipeline这个类需要实现Pipleline<T>。
 * @author dt
 */
@PipelineName("GeccoFactionList")
public class GeccoFactionListPipeline implements Pipeline<GeccoFactionList> {

    @Override
    public void process(GeccoFactionList geccoFactionList) {
        ArrayList<Document> documents = new ArrayList<>();

        //历史 军事 穿越类
        List<SimpleData> lSList = geccoFactionList.getLSList();
        for (SimpleData simpleData : lSList) {
            documents.add(simpleData.getDocument());
        }

        //灵异 科幻类
        List<SimpleData> khList = geccoFactionList.getKHList();
        for (SimpleData simpleData : khList) {
            documents.add(simpleData.getDocument());
        }

        //武侠 仙侠 修真类
        List<SimpleData> wxList = geccoFactionList.getWXList();
        for (SimpleData simpleData : wxList) {
            documents.add(simpleData.getDocument());
        }

        //言情 都市类
        List<SimpleData> yqList = geccoFactionList.getYQList();
        for (SimpleData simpleData : yqList) {
            documents.add(simpleData.getDocument());
        }

        //游戏 竞技 网游类
        List<SimpleData> yxList = geccoFactionList.getYXList();
        for (SimpleData simpleData : yxList) {
            documents.add(simpleData.getDocument());
        }

        //奇幻 玄幻类
        List<SimpleData> xhList = geccoFactionList.getXHList();
        for (SimpleData starDetail : xhList) {
            documents.add(starDetail.getDocument());
        }
        MongoClient.getFactionListClient().insertMany(documents);

        //爬取下一页
//        HttpRequest currRequest = geccoFactionList.getRequest();
//        int currPageNum = geccoFactionList.getCurrPageNum();
//        System.out.println("----------已爬取第"+currPageNum+"页----------");
//        searchNext(currPageNum,currRequest);
    }

    public void searchNext(int currPageNum,HttpRequest currRequest){
        //总页数只有1799
        if (currPageNum<1799){
            int nextPageNum=currPageNum + 1;
            String currUrl = currRequest.getUrl();
            String nextUrl = StringUtils.replaceOnce(currUrl,"page_no="+currPageNum,"page_no="+nextPageNum);
            SchedulerContext.into(currRequest.subRequest(nextUrl));
        } else{
            System.out.println("---------------爬取完毕------------------");
        }

    }
}