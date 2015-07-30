package org.dteam.controller;

import java.sql.SQLException;

import org.dteam.dao.DAOFactory;
import org.dteam.dao.ReadingDAO;
import org.dteam.model.Reading;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String viewDashboard(Model m){
    	m.addAttribute("reading", new Reading());    	
		return "dashboard";	
    }

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public ModelAndView doDashboard(@ModelAttribute Reading reading, Model m) 
		
		        throws ClassNotFoundException, SQLException {
		    ReadingDAO readingDAO = getDAO();
		    readingDAO.addReading(reading);
		    ModelAndView model = new ModelAndView("dashboard");
		    model.addObject("Msg", "Your reading has been added successfully.");
		    return model;		
	}
	
	public ReadingDAO getDAO(){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReadingDAO readingDAO = mysqlFactory.getReadingDAO();
		return readingDAO;
		
	}
    

}
