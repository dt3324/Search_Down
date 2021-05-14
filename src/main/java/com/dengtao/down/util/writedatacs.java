package com.dengtao.down.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class writedatacs {
    //当前文件已经存在
    public static String excelPath = "/Users/akiza/工作/代码/myself/Search_Down/workbook.xls";
    //从第几行插入进去
    public  static  int insertStartPointer = 3;
    //在当前工作薄的那个工作表单中插入这行数据
    public static String sheetName = "title";

    /**
     * 总的入口方法
     */
    public static void main(String[] args) {
        insertRows();
    }
    /**
     * 在已有的Excel文件中插入一行新的数据的入口方法
     */
    public static void insertRows() {
        XSSFWorkbook wb = returnWorkBookGivenFileHandle();
        XSSFSheet sheet1 = wb.getSheet(sheetName);
        XSSFRow row = createRow(sheet1, insertStartPointer);
        createCell(row);
        saveExcel(wb);

    }
    /**
     * 保存工作薄
     * @param wb
     */
    public static void saveExcel(XSSFWorkbook wb) {
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(excelPath);
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 创建要写入的单元格数据 温度 湿度 风力 pm2.5 人口密度
     * @param row
     * @return
     */
    public static XSSFCell createCell(XSSFRow row) {
        XSSFCell cell = row.createCell((short) 0);
        Date date=new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd日:HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd日HH:mm:ss");
//        System.out.println(dateFormat.format(date));
//        cell.setCellValue(wendu);
        row.createCell(0).setCellValue(dateFormat.format(date));
        row.createCell(1).setCellValue(11);
        row.createCell(2).setCellValue(11);
        row.createCell(3).setCellValue(9);
        row.createCell(4).setCellValue(333);
        row.createCell(5).setCellValue(444);
        return cell;
    }
    /**
     * 得到一个已有的工作薄的POI对象
     * @return
     */
    public static XSSFWorkbook returnWorkBookGivenFileHandle() {
        XSSFWorkbook wb = null;
        FileInputStream fis = null;
        File f = new File(excelPath);
        try {
            if (f != null) {
                fis = new FileInputStream(f);
                wb = new XSSFWorkbook(fis);
            }
        } catch (Exception e) {
            return null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return wb;
    }
    /**
     * 找到需要插入的行数，并新建一个POI的row对象
     * @param sheet
     * @param rowIndex
     * @return
     */
    public static XSSFRow createRow(XSSFSheet sheet, Integer rowIndex) {
        XSSFRow row = null;
        if (sheet.getRow(rowIndex) != null) {
            int lastRowNo = sheet.getLastRowNum();
            sheet.shiftRows(rowIndex, lastRowNo, 1);
        }
        row = sheet.createRow(rowIndex);
        return row;
    }

}