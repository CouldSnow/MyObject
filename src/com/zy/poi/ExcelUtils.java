package com.zy.poi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelUtils {

	/**
	 * 创建excel文件	
	 * @param title
	 * @param excelHeader
	 * @param list
	 * @param keys
	 * @return
	 */
	private static  Workbook createWorkBoot(String title,String[] excelHeader,List<Map<String,Object>>list,String[] keys) {
			 Workbook workbook = new HSSFWorkbook();
			//设置sheet的名字
			 Sheet sheet = workbook.createSheet("sheet1");
			 //设置表格宽度
			 for(int i = 0;i<keys.length;i++) {
				 sheet.setColumnWidth(i, 35*150);
			 }
			 //font样式设置字体的大小，是否加粗
			 Font titleFont = createFont(workbook,(short)20,true);
			 Font headerFont = createFont(workbook,(short)12,true);
			 Font bodyFont = createFont(workbook,(short)12,false);
			 //cell的通用样式
			 CellStyle titleStyle = createStyle(workbook,titleFont);
			 CellStyle headerStyle = createStyle(workbook,headerFont);
			 CellStyle bodyStyle = createStyle(workbook,bodyFont);
			 //excel中当前行索引
			 int index=0;
			 //合并标题的单元格设置标题信息及样式
			 sheet.addMergedRegion(new CellRangeAddress(index,index,index,excelHeader.length-1));
			 Row titleRow = sheet.createRow(index++);
			 Cell titleCell = titleRow.createCell(0);
			 titleCell.setCellValue(title);
			 titleCell.setCellStyle(titleStyle);
			 
			 //设置表格头信息及样式
			 Row headerRow = sheet.createRow(index++);
			 for(int i=0;i<excelHeader.length;i++) {
				 Cell headerCell = headerRow.createCell(i);
				 headerCell.setCellValue(excelHeader[i]);
				 headerCell.setCellStyle(headerStyle);
			 }
			 
			 //设置每行每列的值及样式，row为行，cell为方格，创建i*j个方格
			 for(int i=1;i<list.size();i++) {
				 Row bodyRow = sheet.createRow(index++);
				 for(int j=0;j<keys.length;j++) {
					 Cell bodyCell = bodyRow.createCell(j);
					 bodyCell.setCellValue(list.get(i).get(keys[j])==null ?"":list.get(i).get(keys[j]).toString());
					 bodyCell.setCellStyle(bodyStyle);
				 }
			 }
			 
			 return workbook;
			 
		}

		/**
		 * 设置字体样式
		 * @param workbook
		 * @param titleFont
		 * @return
		 */
		private static CellStyle createStyle(Workbook workbook, Font titleFont) {
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFont(titleFont);
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			//背景
			cellStyle.setFillForegroundColor(IndexedColors.WHITE.index);
			cellStyle.setFillBackgroundColor(IndexedColors.WHITE.index);
			cellStyle.setFillPattern(FillPatternType.FINE_DOTS);
			//边跨
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			return cellStyle;
		}

		/**
		 * 设置字体大小，颜色，样式
		 * @param workbook
		 * @param titleFont
		 * @return
		 */
		private static Font createFont(Workbook workbook, short s, boolean b) {
			Font font = workbook.createFont();
			font.setFontHeight(s);
			font.setColor(IndexedColors.BLACK.getIndex());
			font.setFontName("宋体");
			font.setBold(b);
			return font;
		}
		
		/**
		 * 导出表  将表写入内存的输出流再输出到servlet的输入流到客户端
		 * excel表以流的形式导出
		 * @param response
		 * @param list
		 * @return
		 * @throws Exception
		 */
		public static boolean exportExcel (HttpServletResponse response,List<Map<String,Object>>list) throws Exception{
			String fileName = list.get(0).get("filename").toString();
			String[] excelHeader=(String[])list.get(0).get("excelHeader");
			String[] keys=(String[])list.get(0).get("keys");
			String title = list.get(0).get("title").toString();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				//将文件写入输出流
				createWorkBoot(title, excelHeader, list, keys).write(baos);  
			}catch(IOException e) {
				return false;
			}
			byte[] content = baos.toByteArray();
			InputStream is = new ByteArrayInputStream(content);
			
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				response.setHeader("Content-Disposition", "attachment;filement="+new String((fileName+".xls").getBytes(),"iso-8859-1"));
				ServletOutputStream sos = response.getOutputStream();
				bis = new BufferedInputStream(is);
				bos = new BufferedOutputStream(sos);
				byte[] buff = new byte[2048];
				int byteRead =0;
				while(-1!=(byteRead = bis.read(buff,0,buff.length))){
					bos.write(buff,0,byteRead);
				  }
				}catch(IOException e) {
					return false;
				}finally {
					if(bos!=null) {
						bos.close();
					}
					if(bis!=null) {
						bis.close();
					}
					if(is!=null) {
						is.close();
					}
					if(baos!=null) {
						baos.close();
					}
				}
			return true;
		}
}
