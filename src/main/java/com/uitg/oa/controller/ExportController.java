package com.uitg.oa.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uitg.oa.entity.CurrencyCode;
import com.uitg.oa.services.UserService;
import com.uitg.oa.util.LangUtil;

@Controller
@RequestMapping("/eport")
public class ExportController extends BaseController {
	@Autowired
    protected UserService userService;	
	public ExportController() {
		// TODO Auto-generated constructor stub
	}
	

	
	@RequestMapping("/excel")
    public String create(Model model,@ModelAttribute CurrencyCode curr,Errors errors) {
		curr = new CurrencyCode();
		model.addAttribute("curr", curr);
        return "erp/currency"; 
    }

	   public void exportExcel(String title, String[] headers,
		         ArrayList dataset, OutputStream out, String pattern) {
		 
		      HSSFWorkbook workbook = new HSSFWorkbook();
	
		      HSSFSheet sheet = workbook.createSheet(title);
		      //sheet.setDefaultColumnWidth((short) 15);
		      HSSFCellStyle style = workbook.createCellStyle();
		      style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		      style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		      style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		      style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		      style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		      style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		      // 生成一个字体
		      HSSFFont font = workbook.createFont();
		      font.setColor(HSSFColor.VIOLET.index);
		      font.setFontHeightInPoints((short) 12);
		      font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		      // 把字体应用到当前的样式
		      style.setFont(font);
		      // 生成并设置另一个样式
		      HSSFCellStyle style2 = workbook.createCellStyle();
		      style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		      style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		      style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		      style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		      style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		      style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		      style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		      style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		      // 生成另一个字体
		      HSSFFont font2 = workbook.createFont();
		      font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		      // 把字体应用到当前的样式
		      style2.setFont(font2);
		     
		      
		 
		      //产生表格标题行
		      HSSFRow row = sheet.createRow(0);
		      for (short i = 0; i < headers.length; i++) {
		         HSSFCell cell = row.createCell(i);
		         cell.setCellStyle(style);
		         HSSFRichTextString text = new HSSFRichTextString(headers[i]);
		         cell.setCellValue(text);
		      }
		 
		      for (int i = 0; i < dataset.size(); i++)  
		        {  
		            row = sheet.createRow((int) i + 1);   
		            // 第四步，创建单元格，并设置值  
//		            row.createCell((short) 0).setCellValue((double) stu.getId());  
//		            row.createCell((short) 1).setCellValue(stu.getName());  
//		            row.createCell((short) 2).setCellValue((double) stu.getAge());  
//		            cell = row.createCell((short) 3);  
//		            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu  
//		                    .getBirth()));  
		        }  
		      try {
		         workbook.write(out);
		      } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		 
		   }

}


