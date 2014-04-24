package myUtil;

import java.io.*;

public class HanConv {

	public static String toEng(String ko) {
		if(ko == null) {
			return null;
		}

		try
		{
			return new String(ko.getBytes("UTF-8"),"8859_1");
		}
		catch (Exception e)
		{
			return ko;
		}
	}

	public static String toKor(String en) { 

	   if(en == null) {
		   return null;
	   }
	   try {
		   return new String(en.getBytes("8859_1"),"UTF-8");
	   }
	   catch(Exception e) {
		   return en;
	   }
	}
}
