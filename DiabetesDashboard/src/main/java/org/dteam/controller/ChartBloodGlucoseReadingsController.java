package org.dteam.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import static org.dteam.utilities.GetUser.*;
import org.dteam.dao.DAOFactory;
import org.dteam.dao.ReadingDAO;
import org.dteam.model.Reading;
import org.dteam.utilities.JsonArrayMaker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChartBloodGlucoseReadingsController {	
	
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
    public String getChart(HttpServletRequest request){  
		if(getUserInfo(request,"id")==null || getUserInfo(request,"id").isEmpty())
			return "login";
		return "dashboard";	
    }

	@RequestMapping(value = "/chart", method = RequestMethod.POST)	
    public String viewChart(ModelMap model, HttpServletRequest request) 		
		        throws ClassNotFoundException, SQLException {
				ArrayList<String> dateArray = new ArrayList<String>();
				ArrayList<Integer> bgArray = new ArrayList<Integer>();
				ArrayList<Integer> insulinArray = new ArrayList<Integer>();
			    String userID = getUserInfo(request,"id");
				ReadingDAO readingDAO = getDAO();
				String dateRange = request.getParameter("dateRange");
				ArrayList<Reading> readings = readingDAO.getReadings(dateRange, userID);		
				for(Reading reading:readings){
					dateArray.add(reading.getDate());
					bgArray.add(reading.getBloodGlucose());
					insulinArray.add(reading.getInsulin());
				}
				String dates = JsonArrayMaker.makeJsonArray(dateArray);
				String bloodGlucose = JsonArrayMaker.makeJsonArray(bgArray);
				String insulin = JsonArrayMaker.makeJsonArray(insulinArray);
				model.put("dates", dates);
				model.put("bloodGlucose", bloodGlucose);
				model.put("insulin", insulin);				
				return "dashboard";		        		   		    	
	}	
	
	public ReadingDAO getDAO(){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReadingDAO readingDAO = mysqlFactory.getReadingDAO();
		return readingDAO;
		
	}
    

}



