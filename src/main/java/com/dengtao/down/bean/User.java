package com.dengtao.down.bean;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

/**
 * @author dt
 */
@Data
public class User implements HtmlBean {

    //楼号
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(1)")
    private String floor;

    //业主姓名
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(2) > span:nth-child(1)")
    private String ownerName;

    //业主电话
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(2) > span.text-info")
    private String ownerPhone;

    //地址
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(3)")
    private String address;

    //收费类型
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(4)")
    private String feeType;

    //卡号
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(5)")
    private String cardNumber;

    //卡内码
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(6) > span:nth-child(1)")
    private String cardware;

    //车位号
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(7)")
    private String spaceNumber;

    //发卡人
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(8)")
    private String cardholder;

    //卡片启用时间
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(9) > span:nth-child(1)")
    private String startTime;

    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(9) > span.text-danger")
    private String endTime;

    //押金
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(10) > span.text-success")
    private String deposit;

    //卡费
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(10) > span.text-warning")
    private String cardFee;

    //状态
    //@Text
    //@HtmlField(cssPath = "tbody > tr:nth-child > td:nth-child(11) > span")
    private String status;

}
