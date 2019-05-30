package org.sang.security.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.web.multipart.MultipartFile;

public class inExcel {
	
	public static String import2List(MultipartFile file) {
		String id=null;
		String name=null;
		String sex=null;
		String nation=null;
//		Date date=null;
		String date=null;
		try {
			HSSFWorkbook workbook=new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
			int numerOfSheets=workbook.getNumberOfSheets();
			for(int i=0;i<numerOfSheets;i++) {
				HSSFSheet sheet=workbook.getSheetAt(i);
				int rows=sheet.getPhysicalNumberOfRows();
				for(int j=0;j<rows;j++) {
					if(j==0)	
						continue;
					HSSFRow row=sheet.getRow(j);
					if(row==null)
						continue;
					int cells=row.getPhysicalNumberOfCells();
					for(int k=0;k<cells;k++) {
						HSSFCell cell=row.getCell(k);
						switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String cellValue = cell.getStringCellValue();
								switch (k) {
									case 0:
										id=cellValue;
										break;
									case 1:
										name=cellValue;
										break;
									case 2:
										sex=cellValue;
										break;
									case 3:
										nation=cellValue;
										break;
								}
							break;
						default:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
			                	date=DateToStr(cell.getDateCellValue());  
							}
							
		                	break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id+"--"+name+"--"+sex+"--"+nation+"--"+date;
	}

	public static String DateToStr(Date date) {
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("m/d/yy");
		String str = format.format(date);
		return str;
	}
	
}
