/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.mail.internet.ParseException;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author Khalid
 */
public class DateUtil {

    public static long DateDifference(Date fromDate, Date toDate) {
        long days = 0;
          
        //HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
 
		try {
			
 
			//in milliseconds
			long diff = toDate.getTime() - fromDate.getTime();
 
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
 
                        days = diffDays;
//			System.out.print(diffDays + " days, ");
//			System.out.print(diffHours + " hours, ");
//			System.out.print(diffMinutes + " minutes, ");
//			System.out.print(diffSeconds + " seconds.");
 
		} catch (Exception e) {
		}
        
        return days;

    }

    public static Date addDays(Date date, int days) {
        Date newDate ;
        try {
            
         Calendar cal = Calendar.getInstance();  
         cal.setTime(date);  
         cal.add(Calendar.DATE, days); // add 10 days  
          newDate = cal.getTime();              
        } catch (Exception e) {
            return null;
        }
        return newDate;
    }
}
