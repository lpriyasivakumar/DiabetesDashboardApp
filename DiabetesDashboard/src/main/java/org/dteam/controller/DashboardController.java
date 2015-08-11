package org.dteam.controller;

import java.io.UnsupportedEncodingException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dteam.dao.A1cDAO;
import org.dteam.dao.DAOFactory;
import org.dteam.dao.ReadingDAO;
import org.dteam.model.Reading;
import org.dteam.utilities.CookieUtil;
import org.dteam.utilities.JsonArrayMaker;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonArray;

@Controller
public class DashboardController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String viewDashboard(Map<String, Object> model, HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		HttpSession session = request.getSession();
		String userID = CookieUtil.getCookieValue(request, "id");
		if (userID.equals(null) || userID.isEmpty()) {
			return "login";
		} else {
			String dateRange = request.getParameter("dateRange");
			Reading readingForm = new Reading();
			if (dateRange == null || dateRange.isEmpty()) {
				dateRange = "";
			}
			A1cDAO a1cdao = getA1cDAO();			
			double labA1c = a1cdao.getLabValue(userID);
			ModelMap map = getChartData(request, dateRange);
			model.put("dates", map.get("dates"));
			model.put("bloodGlucose", map.get("bloodGlucose"));
			model.put("insulin", map.get("insulin"));
			model.put("readingForm", readingForm);
			model.put("labA1c", labA1c);
			model.put("userName", session.getAttribute("userName").toString());
			model.put("url", session.getAttribute("image").toString());
			return "dashboard";
		}
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String doDashboard(@ModelAttribute("readingForm") Reading reading, ModelMap model,
			HttpServletRequest request) throws ClassNotFoundException, SQLException {

		ReadingDAO readingDAO = getReadingDAO();
		HttpSession session = request.getSession();
		int result1 = 0;
		result1 = readingDAO.addReading(reading, session.getAttribute("userID").toString());
		if (result1 > 0) {
			model.addAttribute("Msg", result1 + " reading added.");
		} else {
			model.addAttribute("Msg", "Reading cannot be saved");
		}		
		session.setAttribute("errMsg", null);
		return "dashboard";
	}

	private ModelMap getChartData(HttpServletRequest request, String dateRange) throws SQLException {
		HttpSession session = request.getSession();
		ArrayList<String> dateArray = new ArrayList<String>();
		ArrayList<Integer> bgArray = new ArrayList<Integer>();
		ArrayList<Integer> insulinArray = new ArrayList<Integer>();
		ReadingDAO readingDAO = getReadingDAO();
		ArrayList<Reading> readings = null;
		readings = readingDAO.getReadings(dateRange, session.getAttribute("userID").toString());
		for (Reading reading : readings) {
			dateArray.add(reading.getDate());
			bgArray.add(reading.getBloodGlucose());
			insulinArray.add(reading.getInsulin());
		}
		ModelMap map = new ModelMap();
		JsonArray dates = JsonArrayMaker.makeJsonArray(dateArray);
		JsonArray bloodGlucose = JsonArrayMaker.makeJsonArray(bgArray);
		JsonArray insulin = JsonArrayMaker.makeJsonArray(insulinArray);
		map.addAttribute("dates", dates);
		map.addAttribute("bloodGlucose", bloodGlucose);
		map.addAttribute("insulin", insulin);
		return map;
	}

	public ReadingDAO getReadingDAO() {
		return DAOFactory.getDAOFactory(DAOFactory.MYSQL).getReadingDAO();
	}

	public A1cDAO getA1cDAO() {
		return DAOFactory.getDAOFactory(DAOFactory.MYSQL).getA1cDAO();
	}

	@ExceptionHandler({SQLException.class, DataAccessException.class,NullPointerException.class})
	public String databaseError() {
		return "databaseError";
	}
	
	
}
