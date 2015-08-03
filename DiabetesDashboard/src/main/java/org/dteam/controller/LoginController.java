package org.dteam.controller;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.dteam.dao.UserDAO;
import org.dteam.dao.DAOFactory;
import org.dteam.utilities.CookieUtil;
import org.dteam.model.User;


@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin() {		
		return "login";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String id =CookieUtil.getCookieValue(cookies, "id");
		String name =CookieUtil.getCookieValue(cookies, "user");
		UserDAO userDAO = getDAO();
		if(!userDAO.findUser(id)){
			User user = new User();
			user.setUserID(id);			
			user.setName(java.net.URLDecoder.decode(name));
			userDAO.addUser(user);
		}
		    return new ModelAndView("redirect:/dashboard"); 
	}
	
	public UserDAO getDAO(){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UserDAO userDAO = mysqlFactory.getUserDAO();
		return userDAO;
		
	}

}
