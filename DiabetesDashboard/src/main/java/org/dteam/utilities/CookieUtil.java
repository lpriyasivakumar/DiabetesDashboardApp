package org.dteam.utilities;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
	public static String getCookieValue(Cookie[] cookies, String cookieName){
		String cookieValue = "";
		if(cookies!= null){
			for(Cookie cookie:cookies){
				if(cookieName.equals(cookie.getName())){
					cookieValue = cookie.getValue();
				}
			}
		}
		return cookieValue;
		
	}
	public static String getUserInfo(HttpServletRequest request,String cookieName) {
		Cookie[] cookies = request.getCookies();
		String userInfo = CookieUtil.getCookieValue(cookies, cookieName);
		return userInfo;
	}

}
