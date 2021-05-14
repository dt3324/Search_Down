package com.dengtao.down.spyy;

import com.dengtao.down.bean.User;
import com.dengtao.down.util.ExcelExportUtil;
import com.dengtao.down.util.ExcelUtil;
import com.dengtao.down.util.ExcelUtiles;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 从笔趣阁抓取小说列表
 *
 * @author dt
 */
public class GeccoSpyyMain {
    public static void main(String url) {
        //获取网站请求
        HttpGetRequest start = new HttpGetRequest(url);
        start.setCharset("UTF-8");
        //创建搜索引擎
        GeccoEngine.create()
                //要搜索的包名，会自动搜索该包下，含@Gecco注解的文件。
                .classpath("com.dengtao.down.spyy")
                .start(start)
                //开启多少个线程抓取
                .thread(5)
                //隔多长时间抓取1次
                .interval(2000)
                .run();
    }

    public static String getHtml(String urlString) {
        try {
            StringBuffer html = new StringBuffer();
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Cookie", "PHPSESSID=357e8c7c02c2eb8af38d674e5cf484e7; uppark_admin=bd3ce84152f99082b6ee56ff251eef32fTUYTVndfm9K5gck6voUMv%2BDSXJf%2FFbx9%2FQeCOR84DPxaUFunmoDRomOthfGNDUbsmCbaceXfiuagw8XneNJikg%2FDf7kMrvJG%2BSTEVhle83xMX01OKwy5TCNyvDoTCv8fVS%2Bqv%2B97AinsmyHP%2BJmGM19SQ");
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String temp;
            while ((temp = br.readLine()) != null) {
                html.append(temp).append("\n");

            }
            br.close();
            isr.close();
            return html.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public static void main(String[] args) throws Exception {
        String fileName = "/workbook14.xlsx";
        int num = 14;
        String html = GeccoSpyyMain.getHtml("https://park.ibaizhe.cn/uppman/park/owner/index.html?sp_provice=0&sp_city=0&sp_county=0&sp_park_name=&sp_park_id=0&sp_keywords=&sp_otype_id=0&sp_create_start_time=&sp_create_end_time=&sp_start_time=&sp_end_time=&sp_state=all&sp_issue_admin_name=&sp_issue_admin_id=0&ps=100&p="+ num);
//        System.out.println(html);
        //6.Jsoup解析html
        Document document = Jsoup.parse(html);
        //像js一样，通过标签获取title
//        System.out.println(document.getElementsByTag("title").first());
        //像js一样，通过id 获取文章列表元素对象
        Elements byClass = document.select("body > div.container-fluid.pt20 > div.panel.panel-default > table > tbody");
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Map<String, Object>> users1 = new ArrayList<>();
        for (Element aClass : byClass) {
            Elements children = aClass.children();
            for (Element child : children) {
                String text = child.text();
//                System.out.println(text);
                String[] s = text.split(" ");
//                users1.add(s);
                User user = new User();
                Map<String, Object> map = new HashMap<>();
                for (int i = 0; i < s.length; i++) {
                    if (i == 0) {
                        map.put("floor", s[0]);
                        user.setFloor(s[0]);
                    }
                    if (i == 1) {
                        map.put("ownerName",s[1]);
                        user.setOwnerName(s[1]);
                    }
                    if (i == 2) {
                        map.put("ownerPhone",s[2]);
                        user.setOwnerPhone(s[2]);
                    }
                    if (i == 3) {
                        map.put("address",s[3]);
                        user.setAddress(s[3]);
                    }
                    if (i == 4) {
                        map.put("feeType",s[4]);
                        user.setFeeType(s[4]);
                    }
                    if (i == 5) {
                        map.put("cardNumber",s[5]);
                        user.setCardNumber(s[5]);
                    }
                    if (i == 6) {
                        map.put("cardware",s[6]);
                        user.setCardware(s[6]);
                    }
                    if (i == 7) {
                        map.put("spaceNumber",s[7]);
                        user.setSpaceNumber(s[7]);
                    }
                    if (i == 8) {
                        map.put("cardholder",s[8]);
                        user.setCardholder(s[8]);
                    }
                    if (i == 9) {
                        map.put("startTime",s[9]);
                        user.setStartTime(s[9]);
                    }
                    if (i == 10) {
                        map.put("endTime",s[10]);
                        user.setEndTime(s[10]);
                    }
                    if (i == 11) {
                        map.put("deposit",s[11]);
                        user.setDeposit(s[11]);
                    }
                    if (i == 12) {
                        map.put("cardFee",s[12]);
                        user.setCardFee(s[12]);
                    }
                    if (i == 13) {
                        map.put("status",s[13]);
                        user.setStatus(s[13]);
                    }

                }
                users1.add(map);
            }
        }
        String[] title = {"楼号", "业主姓名", "业主电话", "地址", "收费类型", "卡号", "卡内码", "车位号", "发卡人", "卡片启用时间", "卡片结束时间", "押金", "卡费", "状态"};
        String sheetTitle = "title";
        String[] properties = new String[]{"floor", "ownerName", "ownerPhone", "address", "cardNumber", "cardware", "spaceNumber", "cardholder", "startTime", "endTime", "deposit", "cardFee", "status"};  // 查询对应的字段
        ExcelExportUtil excelExport2 = new ExcelExportUtil();
        excelExport2.setData(users1);
        excelExport2.setHeardKey(properties);
        excelExport2.setFontSize(14);
        excelExport2.setSheetName(sheetTitle);
        excelExport2.setTitle(sheetTitle);
        excelExport2.setHeardList(title);
        try {

            FileOutputStream fileOut = new FileOutputStream(new File("").getAbsoluteFile() + fileName);
            byte[] data = excelExport2.exportExport(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public static void main1(String[] args) {
//        String[] title = {"楼号", "业主姓名", "业主电话", "地址", "收费类型", "卡号", "卡内码", "车位号", "发卡人", "卡片启用时间", "卡片结束时间", "押金", "卡费", "状态"};
//        String sheetTitle = "title";
//        String[] properties = new String[]{"", "", "", "", "", ""};  // 查询对应的字段
//        ExcelExportUtil excelExport2 = new ExcelExportUtil();
//        excelExport2.setData(maps);
//        excelExport2.setHeardKey(properties);
//        excelExport2.setFontSize(14);
//        excelExport2.setSheetName(sheetTitle);
//        excelExport2.setTitle(sheetTitle);
//        excelExport2.setHeardList(title);
//        try {
//            byte[] data = excelExport2.exportExport();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}