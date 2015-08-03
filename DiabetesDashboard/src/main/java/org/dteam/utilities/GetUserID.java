package org.dteam.utilities;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class GetUserID {
	public static String getUserID(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String userID = CookieUtil.getCookieValue(cookies, "id");
		return userID;
	}
}
