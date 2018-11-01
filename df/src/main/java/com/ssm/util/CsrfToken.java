package com.ssm.util;

import java.util.UUID;

public class CsrfToken {
	public static  String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
   }
	public static String getCsrfToken() {
		
		return getUUID();
	}
}
