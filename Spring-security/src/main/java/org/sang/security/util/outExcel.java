package org.sang.security.util;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.Date;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class outExcel {

	public static ResponseEntity<byte[]> export2Excel(){
		org.springframework.http.HttpHeaders headers=null;
		ByteArrayOutputStream baos=null;
		try {
			// 1、创建Excel文档
			HSSFWorkbook workbook=new HSSFWorkbook();
			// 2、创建文档摘要
			workbook.createInformationProperties();
			// 3、获取文档信息，并配置
			// 文档类别、文档管理员、组织机构
			DocumentSummaryInformation dsi=workbook.getDocumentSummaryInformation();
			dsi.setCategory("员工信息");
			dsi.setManager("anxing");
			dsi.setCompany("anxinghei");
			// 4、获取摘要信息，并配置
			// 文档主题、文档标题、文档作者、文档备注
			SummaryInformation si=workbook.getSummaryInformation();
			si.setSubject("员工信息表");
			si.setTitle("员工信息");
			si.setAuthor("anxinghei");
			si.setComments("备注信息暂无");
			// 创建Excel表单
			HSSFSheet sheet=workbook.createSheet("--员工信息表--");
			// 创建日期显示格式
			HSSFCellStyle dateCellStyle=workbook.createCellStyle();
			dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
			// 创建标题的显示格式
			HSSFCellStyle headerCellStyle=workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
			headerCellStyle.setFillPattern(HSSFCellStyle.SQUARES);
			sheet.setColumnWidth(0, 30*256);
			sheet.setColumnWidth(1, 30*256);
			sheet.setColumnWidth(2, 30*256);
			sheet.setColumnWidth(3, 30*256);
			sheet.setColumnWidth(4, 30*256);
			// 5、设置表头
			HSSFRow headeRow=sheet.createRow(0);
			HSSFCell cell0=headeRow.createCell(0);
			cell0.setCellValue("编号");
			cell0.setCellStyle(headerCellStyle);
			HSSFCell cell1=headeRow.createCell(1);
			cell1.setCellValue("姓名");
			cell1.setCellStyle(headerCellStyle);
			HSSFCell cell2=headeRow.createCell(2);
			cell2.setCellValue("性别");
			cell2.setCellStyle(headerCellStyle);
			HSSFCell cell3=headeRow.createCell(3);
			cell3.setCellValue("民族");
			cell3.setCellStyle(headerCellStyle);
			HSSFCell cell4=headeRow.createCell(4);
			cell4.setCellValue("出生日期");
			cell4.setCellStyle(headerCellStyle);
			// 6、数据填充
			HSSFRow row=sheet.createRow(1);
			row.createCell(0).setCellValue("99");
			row.createCell(1).setCellValue("张三");
			row.createCell(2).setCellValue("男");
			row.createCell(3).setCellValue("汉族");
			HSSFCell dateCell=row.createCell(4);
			dateCell.setCellValue(new Date());
			dateCell.setCellStyle(dateCellStyle);
			// 收尾
			headers=new org.springframework.http.HttpHeaders();
			headers.setContentDispositionFormData("attachment", new String("员工表.xls".getBytes("UTF-8"),"iso-8859-1"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			baos=new ByteArrayOutputStream();
			workbook.write(baos);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<byte[]>(baos.toByteArray(),headers,HttpStatus.CREATED);
	}
}
