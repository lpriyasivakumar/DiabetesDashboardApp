package org.dteam.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import org.dteam.dao.DAOFactory;
import org.dteam.dao.ReadingDAO;
import org.dteam.model.Reading;
import org.dteam.utilities.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String viewDashboard(Map<String, Object> model){
		Reading readingForm = new Reading();		
    	model.put("readingForm", readingForm); 
    	
		return "dashboard";	
    }

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public String doDashboard(@ModelAttribute("readingForm") Reading reading,BindingResult result,
    		ModelMap model,HttpServletRequest request,HttpServletResponse response) 
		
		        throws ClassNotFoundException, SQLException {
		 	if (result.hasErrors()) {
		 		 model.addAttribute("errorMsg", "Your form submission contains errors.");	 
	        } else {
	        	ReadingDAO readingDAO = getDAO();
			    Cookie[] cookies = request.getCookies();
			    String userID = CookieUtil.getCookieValue(cookies, "id");
			    int result1 = readingDAO.addReading(reading,userID);
			    model.addAttribute("successMsg", result1 +" reading added.");
	        }		   
		    return "dashboard";		
	}
	
	public ReadingDAO getDAO(){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReadingDAO readingDAO = mysqlFactory.getReadingDAO();
		return readingDAO;
		
	}
    

}
