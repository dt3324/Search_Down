package com.dengtao.down.spyy;

import com.dengtao.down.bean.User;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * /@pipelineName 标签指定了pipline的名字。并且pipeline这个类需要实现Pipleline<T>。
 * @author dt
 */
@PipelineName("starIndexPagePipeline")
public class GeccoFictionSpyyPipeline implements Pipeline<GeccoFictionSpyy> {

    @Override
    public void process(GeccoFictionSpyy geccoFictionSpyy) {

        //历史 军事 穿越类
        List<User> users = geccoFictionSpyy.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        //爬取下一页
//        HttpRequest currRequest = geccoFictionSpyy.getRequest();
//        int currPageNum = 1;
//        System.out.println("----------已爬取第"+currPageNum+"页----------");
//        searchNext(currPageNum,currRequest);
    }

    public void searchNext(int currPageNum,HttpRequest currRequest){
        //总页数只有1799
        if (currPageNum<139){
            int nextPageNum=currPageNum + 1;
            String currUrl = currRequest.getUrl();
            String nextUrl = StringUtils.replaceOnce(currUrl,"page_no="+currPageNum,"page_no="+nextPageNum);
            SchedulerContext.into(currRequest.subRequest(nextUrl));
        } else{
            System.out.println("---------------爬取完毕------------------");
        }

    }
}