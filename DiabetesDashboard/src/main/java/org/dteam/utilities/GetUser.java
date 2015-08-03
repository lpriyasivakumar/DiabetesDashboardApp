package org.dteam.utilities;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class GetUser {
	public static String getUserInfo(HttpServletRequest request,String cookieName) {
		Cookie[] cookies = request.getCookies();
		String userID = CookieUtil.getCookieValue(cookies, cookieName);
		return userID;
	}
}
