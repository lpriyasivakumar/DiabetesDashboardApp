package org.dteam.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.dteam.utilities.GetUserID.*;
import org.dteam.dao.DAOFactory;
import org.dteam.dao.ReadingDAO;
import org.dteam.model.Reading;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DashboardController {
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String viewDashboard(Map<String, Object> model,HttpServletRequest request) {
		if(getUserID(request)==null || getUserID(request).isEmpty()){
			return "login";
		}			
		else{			
			Reading readingForm = new Reading();
			model.put("readingForm", readingForm);
			return "dashboard";
		}
		
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String doDashboard(@ModelAttribute("readingForm") Reading reading, BindingResult result, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ReadingDAO readingDAO = getDAO();		
		String userID = getUserID(request);
		int result1 = readingDAO.addReading(reading, userID);
		if (result1 > 0)
			model.addAttribute("Msg", result1 + " reading added.");
		else
			model.addAttribute("Msg", "Invalid entries. Cannot save reading");
		return "dashboard";
	}

	public ReadingDAO getDAO() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReadingDAO readingDAO = mysqlFactory.getReadingDAO();
		return readingDAO;

	}
	

}
