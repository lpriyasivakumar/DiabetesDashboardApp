package org.dteam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.dteam.dao.A1cDAO;
import org.dteam.dao.DAOFactory;
import org.dteam.utilities.CalcA1cEst;

@Controller
public class A1cController {

	DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	@RequestMapping(value = "/A1c", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request,ModelMap model) {
		HttpSession session = request.getSession();
		A1cDAO a1cdao = mysqlFactory.getA1cDAO();
		String action = request.getParameter("action");
		String userID = session.getAttribute("userID").toString();
		double calcA1c=0;
		double labA1c = Double.parseDouble(request.getParameter("labA1c"));
		if (action.equals("saveLabValue")) {
			a1cdao.addLabValue(labA1c, userID);
			labA1c = a1cdao.getLabValue(userID);
		} else if (action.equals("CalcA1c")) {
			calcA1c = CalcA1cEst.getCalcA1cEstimate(userID);
		}		
		model.addAttribute("labA1c", labA1c);
		model.addAttribute("CalcA1c", calcA1c);
		return new ModelAndView("redirect:/dashboard");
	}

}
