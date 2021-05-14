package com.dengtao.down.util;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @ClassName ReadExcel
 * @Description TODO
 * @Author shuai
 * @Date 2018/8/9 17:43
 * @Version 1.0
 **/
public class test2 {

    public static void main(String[] args) {
        List<Map<String, String>> retList = readExcel("/Users/akiza/工作/代码/myself/Search_Down/workbook.xls");
        System.out.println("文件的数据：" + retList);
        for (int i = 0; i < retList.size(); i++) {
            for (Entry<String, String> entry : retList.get(i).entrySet()) {
                System.out.println("key:" + entry.getKey() + ";value:" + entry.getValue());
                if ("".equals(entry.getValue())) {

                }
            }
        }
    }

    public static List<Map<String, String>> readExcel(String path) {
        List<Map<String, String>> retList = new ArrayList<Map<String, String>>();
        File file = new File(path);
        FileInputStream fis = null;
        Workbook workBook = null;
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                workBook = WorkbookFactory.create(fis);
                int numberOfSheets = workBook.getNumberOfSheets();
// sheet工作表
                for (int s = 0; s < numberOfSheets; s++) {
                    Sheet sheetAt = workBook.getSheetAt(s);
// 获取工作表名称
                    String sheetName = sheetAt.getSheetName();
// 获取当前Sheet的总行数
                    int rowsOfSheet = sheetAt.getPhysicalNumberOfRows();
// 第一行
                    Row row0 = sheetAt.getRow(0);
                    int physicalNumberOfCells = sheetAt.getRow(0).getPhysicalNumberOfCells();
                    String[] title = new String[physicalNumberOfCells];
                    for (int i = 0; i < physicalNumberOfCells; i++) {
                        title[i] = row0.getCell(i).getStringCellValue();
                    }
                    Integer totalCells = title.length;
                    for (int r = 1; r < rowsOfSheet; r++) {
                        Row row = sheetAt.getRow(r);
                        if (row == null) {
                            continue;
                        }
                        Map<String, String> rowMap = new HashMap<String, String>();
                        int rowNum = row.getRowNum() + 1;
                        System.out.println("当前行:" + rowNum);
/** 循环Excel的列 */
                        Cell cell0 = row.getCell(0);
                        String cellValue = "";
                        if (null != cell0) {
// 以下是判断数据的类型
                            switch (cell0.getCellType()) {
                                case HSSFCell.CELL_TYPE_STRING: // 字符串
                                    cellValue = cell0.getStringCellValue();
                                    break;
                                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                                    cellValue = cell0.getBooleanCellValue() + "";
                                    break;
                                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                                    cellValue = cell0.getCellFormula() + "";
                                    break;
                                case HSSFCell.CELL_TYPE_BLANK: // 空值
                                    cellValue = "";
                                    break;
                                case HSSFCell.CELL_TYPE_ERROR: // 故障
                                    cellValue = "非法字符";
                                    break;
                                default:
                                    cellValue = cell0.getStringCellValue();
                                    break;
                            }
                        }
                        Cell cell1 = row.getCell(1);
                        String cell1Value = "";
                        if (null != cell1) {
// 以下是判断数据的类型
                            switch (cell1.getCellType()) {
                                case HSSFCell.CELL_TYPE_STRING: // 字符串
                                    cell1Value = cell1.getStringCellValue();
                                    break;
                                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                                    cell1Value = cell1.getBooleanCellValue() + "";
                                    break;
                                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                                    cell1Value = cell1.getCellFormula() + "";
                                    break;
                                case HSSFCell.CELL_TYPE_BLANK: // 空值
                                    cell1Value = "";
                                    break;
                                case HSSFCell.CELL_TYPE_ERROR: // 故障
                                    cell1Value = "非法字符";
                                    break;
                                default:
                                    cell1Value = cell1.getStringCellValue();
                                    break;
                            }
                        }
                        rowMap.put(cellValue, cell1Value);
                        retList.add(rowMap);
                    }
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在!");
        }
        return retList;
    }
}

