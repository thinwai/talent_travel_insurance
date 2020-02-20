package com.travelinsurance.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component
public class MessagesUtil {
	
	public void messageWarn(String sms) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_WARN, sms ,"WARN Messages"));
	}
	
	public void messageError(String sms) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, sms,"ERROR Messages"));
	}
	public void messageInfo(String sms) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, sms,"INFO Messages"));
	}
	public String proposalId() {
		int i=0;
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String date = myDateObj.format(myFormatObj);
	    
	    if(i<10) {
	    	i++;
	    }else {
	    	i=0;
	    }
	    String propoId="PR"+date.substring(6,10)+date.substring(3,5)+date.substring(0,2)+date.substring(11,13)+date.substring(14,16)+date.substring(17,19)+i;
	    
	    System.out.println(date+ " | "+"PROPOSAL ID: " + propoId);
	    return propoId;
	}
	
	public int dateToInteger(Date date) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String strDate= formatter.format(date);
		System.out.println("Date Ulti before+ |"+strDate);
		
		String result=strDate.substring(0,4)+strDate.substring(5,7)+strDate.substring(8,10);
		System.out.println("Date Ulti Result + |"+result);
		return Integer.parseInt(result);
	}
	
	public String dateFormat(Date date) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate= formatter.format(date);
		
		return strDate;
	}
}
