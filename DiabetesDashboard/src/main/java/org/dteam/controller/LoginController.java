package org.dteam.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.dteam.dao.UserDAO;
import org.dteam.dao.A1cDAO;
import org.dteam.dao.DAOFactory;
import org.dteam.utilities.CookieUtil;
import org.dteam.model.User;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin() {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		HttpSession session = request.getSession();
		String id = CookieUtil.getCookieValue(request, "id");
		String name = URLDecoder.decode(CookieUtil.getCookieValue(request, "user"),
				java.nio.charset.StandardCharsets.UTF_8.toString());
		String image = URLDecoder.decode(CookieUtil.getCookieValue(request, "image"),
				java.nio.charset.StandardCharsets.UTF_8.toString());
		session.setAttribute("userID", id);
		session.setAttribute("userName", name);
		session.setAttribute("image", image);
		session.setAttribute("calcA1c","0");
		UserDAO userDAO = getUserDAO();
		if (!userDAO.findUser(id)) {
			User user = new User();
			user.setUserID(id);
			user.setName(name);
			userDAO.addUser(user);
			A1cDAO a1cDAO = getA1cDAO();
			a1cDAO.addLabValue(0, id);

		}
		return new ModelAndView("redirect:/dashboard");
		
		
	}

	public UserDAO getUserDAO() {
		return DAOFactory.getDAOFactory(DAOFactory.MYSQL).getUserDAO();
	}

	public A1cDAO getA1cDAO() {
		return DAOFactory.getDAOFactory(DAOFactory.MYSQL).getA1cDAO();

	}

}
