package com.dengtao.down.util;

import com.dengtao.down.spyy.GeccoSpyyMain;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//本类创建用于HTML文件解释工具  
public class HtmlParserTool {

    public static void main(String[] args) {
        String fileName = "/workbook.xlsx";
        int num = 1;
        String html = GeccoSpyyMain.getHtml("https://park.ibaizhe.cn/uppman/park/owner/index.html?ps=100&p=" + num);
//        System.out.println(extractLinks(html));

        Elements tbody = Jsoup.parse(html).body().getElementsByTag("tr");
        ArrayList<Map<String, String>> list = new ArrayList<>();
        for (int i = 1; i < tbody.size(); i++) {
            Element element = tbody.get(i);
//            System.out.println(element.getElementsByTag("td"));
            Elements td = element.getElementsByTag("td");
            Map<String, String> map = new HashMap<>();
            try {
                map.put("floor", td.get(0).text());
                map.put("ownerName", td.get(1).getElementsByTag("span").get(0).text());
                map.put("ownerPhone", td.get(1).getElementsByTag("span").get(1).text());
                map.put("address", td.get(2).text());
                map.put("feeType", td.get(3).text());
                map.put("cardNumber", td.get(4).text());
                map.put("cardware", td.get(5).getElementsByTag("span").get(0).text());
                map.put("spaceNumber", td.get(5).getElementsByTag("span").get(1).text());
                map.put("cardholder", td.get(7).text());
                map.put("startTime", td.get(8).getElementsByTag("span").get(0).text());
                map.put("endTime", td.get(8).getElementsByTag("span").get(1).text());
                map.put("deposit", td.get(9).getElementsByTag("span").get(0).text());
                map.put("cardFee", td.get(9).getElementsByTag("span").get(1).text());
                map.put("status", td.get(10).text());
//                System.out.println(map);
            } catch (Exception e) {
            }
            list.add(map);
        }
        String[] title = {"楼号", "业主姓名", "业主电话", "地址", "收费类型", "卡号", "卡内码", "车位号", "发卡人", "卡片启用时间", "卡片结束时间", "押金", "卡费", "状态"};
        String sheetTitle = "title";
        String[] properties = new String[]{"floor", "ownerName", "ownerPhone", "address", "cardNumber", "cardware", "spaceNumber", "cardholder", "startTime", "endTime", "deposit", "cardFee", "status"};  // 查询对应的字段
        ExcelExportUtil excelExport2 = new ExcelExportUtil();
        excelExport2.setData(list);
        excelExport2.setHeardKey(properties);
        excelExport2.setFontSize(14);
        excelExport2.setSheetName(sheetTitle);
        excelExport2.setTitle(sheetTitle);
        excelExport2.setHeardList(title);
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("").getAbsoluteFile() + fileName);
            byte[] data = excelExport2.exportExport(fileOut);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
