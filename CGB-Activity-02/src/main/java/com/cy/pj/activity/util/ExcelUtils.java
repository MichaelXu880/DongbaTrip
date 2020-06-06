package com.cy.pj.activity.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelUtils {
	 private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

	    //列名
	    public static final String FIELDNAME = "fieldName";
	    //列中文名
	    public static final String FIELDZNAME = "fieldZName";

	    public static void exportToExcel() {

	    }

	    /**
	     * 生成workbook，并进行数据处理
	     * @param list 数据
	     * @param fieldList 列数据
	     * @return
	     */
	    public static <T> Workbook dealWorkbook(List<T> list , List<Map<String , String>> fieldList) {
	        //创建一个excel2003的WorkBook,对应一个Excel文件
	        Workbook workbook = new HSSFWorkbook();
	        try {
	            //在Workbook中，创建一个sheet,名为test，对应Excel中的工作薄（sheet）
	            Sheet sheet = workbook.createSheet("test");
	            dealSheetData(sheet , list , fieldList);
	        } catch (Exception e) {
	            logger.info("导出Excel失败！");
	            logger.error(e.getMessage());
	        }
	        return workbook;
	    }

	    /**
	     * 处理sheet的数据内容
	     * @param sheet sheet内容
	     * @param list 数据
	     * @param fieldList 列名
	     */
	    private static <T> void dealSheetData(Sheet sheet, List<T> list, List<Map<String, String>> fieldList) {
	        //在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
	        Row row = sheet.createRow( 0);
	        // 填充表头
	        for(int i = 0; i < fieldList.size();i++) {
	            Cell cell = row.createCell(i);
	            Map<String, String> fields = fieldList.get(i);
	            cell.setCellValue(fields.get(FIELDZNAME));
	            sheet.autoSizeColumn(i);
	        }

	        // 填充内容
	        for (int index = 0; index < list.size(); index++) {
	            row = sheet.createRow(index + 1);
	            T item = list.get(index);
	            for (int i = 0; i < fieldList.size(); i++) {
	                Map<String, String> fields = fieldList.get(i);
	                Object objValue = getItemFieldValue(fields.get(FIELDNAME) , item);
	                String fieldValue = objValue == null ? "" : objValue.toString();
	                row.createCell(i).setCellValue(fieldValue);
	            }
	        }
	    }

	    /**
	     * 得到属性的值
	     * @param fieldName
	     * @param item
	     * @return
	     */
	    private static <T> Object getItemFieldValue(String fieldName, T item) {
	        try {
	            Field field = item.getClass().getDeclaredField(fieldName);
	            field.setAccessible(true);
	            //属性的值
	            return  field.get(item);
	        } catch (Exception e) {
	            logger.error("field {} is error" , fieldName , e);
	            return null;
	        }

	    }
	}

