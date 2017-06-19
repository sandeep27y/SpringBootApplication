package com.example.SpringApp.repository;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeUtill {
	public static java.sql.Date dateParsingToSQL(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date utildate = null;
		try {
			utildate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqldate = new java.sql.Date(utildate.getTime());
		return sqldate;
		
	}
}
