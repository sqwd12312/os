package com.bwm.time;
import java.util.*;
import java.text.*;

public class Time {
	private Date time;
	private String strtime;
	private SimpleDateFormat format;  
	

	public Time() {
		time=new Date();
		strtime="";
		format=null;
	}


	public int getYear(){
		format=new SimpleDateFormat("yyyy",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}


	public int getMonth(){
		format=new SimpleDateFormat("MM",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}


	public int getDate(){
		format=new SimpleDateFormat("dd",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}


	public int getHour(){
		format=new SimpleDateFormat("HH",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}


	public int getMinute(){
		format=new SimpleDateFormat("mm",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}


	public int getSecond(){
		format=new SimpleDateFormat("ss",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}


	public String getYMD(){
		time=new Date();
		format=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
		strtime=format.format(time);
		return strtime;
	}


	public String getHMS(){
		time=new Date();
		format=new SimpleDateFormat("HH:mm:ss",Locale.getDefault());
		strtime=format.format(time);
		return strtime;
	}

	public String getYMDHMS(){
		format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
		strtime=format.format(time);
		return strtime;
	}

	public int getCyear(Date d){
		format=new SimpleDateFormat("yyyy",Locale.getDefault());
		return Integer.parseInt(format.format(d))-getYear();
	}


	public int getCmonth(Date d){
		format=new SimpleDateFormat("MM",Locale.getDefault());
		return Integer.parseInt(format.format(d))-getMonth();
	}


	public int getCdate(Date d){
		format=new SimpleDateFormat("dd",Locale.getDefault());
		return Integer.parseInt(format.format(d))-getDate();
	}
	

	public int getChour(Date d){
		format=new SimpleDateFormat("HH",Locale.getDefault());
		return Integer.parseInt(format.format(d))-getHour();
	}

	public int getCminute(Date d){
		format=new SimpleDateFormat("mm",Locale.getDefault());
		return Integer.parseInt(format.format(d))-getMinute();
	}
}
