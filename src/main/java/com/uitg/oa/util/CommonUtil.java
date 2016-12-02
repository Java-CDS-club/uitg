package com.uitg.oa.util;

import java.text.DecimalFormat;

public class CommonUtil {
   
	public CommonUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static String doublewith2(double value) {   //保留小数点后3位（四舍五入），且不按科学计数法输出
		String retValue = null;
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(2);
		df.setMaximumFractionDigits(2);
		retValue = df.format(value);
		retValue = retValue.replaceAll(",", "");
		return retValue;
   }
}
