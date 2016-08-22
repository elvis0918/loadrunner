package com.test.java;
/*
 * LoadRunner Java script. (Build: _build_number_)
 * 
 * Script Description: 
 *                     
 */

import lrapi.lr;
import lrapi.web;

public class Actions1
{
	public int init() throws Throwable {
		return 0;
	}

	public int action() throws Throwable {
//	    lr.start_transaction("test start");
//	    lr.end_transaction("test start",lr.AUTO);
		lr.start_transaction("S01_T01_HomePage");
	    web.url("Open Webtours", "URL=http://127.0.0.1:1080/WebTours/", new String[]{
	    		"Resource=0",
			    "RecContentType=text/html",
			    "Referer=",
			    "Snapshot=t1.inf",
			    "Mode=HTML",
			    web.LAST
	    });
	    lr.end_transaction("S01_T01_HomePage", lr.AUTO);
	    lr.think_time(3);
	    lr.start_transaction("S01_T02_LogIn");
	    web.submit_form("login.pl",
		    new String[]{},
		    new String[]{
	    		"Name=username", "Value=jojo", web.ENDITEM,
			    "Name=password", "Value=bean", web.ENDITEM,
			    "Name=login.x", "Value=43", web.ENDITEM,
			    "Name=login.y", "Value=12", web.ENDITEM,
			    web.LAST
	    	}
	    );
	    lr.end_transaction("S01_T02_LogIn", lr.AUTO);
	    lr.think_time(5);
		return 0;
	}


	public int end() throws Throwable {
		return 0;
	}
}
