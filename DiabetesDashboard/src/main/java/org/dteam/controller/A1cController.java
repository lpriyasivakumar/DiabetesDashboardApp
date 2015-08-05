package org.dteam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.dteam.dao.A1cDAO;
import org.dteam.dao.DAOFactory;
import org.dteam.utilities.CalcA1cEst;

@Controller
public class A1cController {

	DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	@RequestMapping(value = "/A1c", method = RequestMethod.POST)
	public ModelAndView doLogin(@RequestParam String action) {
		A1cDAO a1cdao = mysqlFactory.getA1cDAO();
		if (action.equals("saveLabValue")) {
			a1cdao.addLabValue("", userID);
		} else if (action.equals("CalcA1c")) {
			CalcA1cEst.getCalcA1cEstimate(userID);
		}
		return new ModelAndView("redirect:/dashboard");
	}

}
