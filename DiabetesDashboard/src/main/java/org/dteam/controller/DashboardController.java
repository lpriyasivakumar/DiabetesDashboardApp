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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonArray;

@Controller
public class DashboardController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String viewDashboard(Map<String, Object> model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		HttpSession session = request.getSession();
		String userID = CookieUtil.getCookieValue(request, "id");
		if (userID.equals(null) || userID.isEmpty()) {
			return "login";
		} else {
			String dateRange = request.getParameter("dateRange");
			Reading readingForm = new Reading();
			if (dateRange == null || dateRange.isEmpty()) {
				dateRange = "all";
			}
			A1cDAO a1cdao = getA1cDAO();
			double labA1c = 0;
			try {
				labA1c = a1cdao.getLabValue(userID);
			} catch (SQLException e) {
				System.out.println("Error adding to database.");
			}
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
	public String doDashboard(@ModelAttribute("readingForm") Reading reading, ModelMap model, String calcA1c,
			HttpServletRequest request) throws ClassNotFoundException {

		ReadingDAO readingDAO = getReadingDAO();
		HttpSession session = request.getSession();
		int result1 = 0;
		try {
			result1 = readingDAO.addReading(reading, session.getAttribute("userID").toString());
		} catch (SQLException e) {
			System.out.println(" DB Error");
		}

		if (result1 > 0) {
			model.addAttribute("Msg", result1 + " reading added.");
		} else {
			model.addAttribute("Msg", "Invalid entries. Cannot save reading");
		}
		model.addAttribute("calcA1c", calcA1c);
		return "dashboard";
	}

	private ModelMap getChartData(HttpServletRequest request, String dateRange) {
		HttpSession session = request.getSession();
		ArrayList<String> dateArray = new ArrayList<String>();
		ArrayList<Integer> bgArray = new ArrayList<Integer>();
		ArrayList<Integer> insulinArray = new ArrayList<Integer>();
		ReadingDAO readingDAO = getReadingDAO();
		ArrayList<Reading> readings = null;
		try {
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
		} catch (SQLException e) {
			System.out.println("Error fetching readings");
		}
		return null;

	}

	public ReadingDAO getReadingDAO() {
		return DAOFactory.getDAOFactory(DAOFactory.MYSQL).getReadingDAO();

	}

	public A1cDAO getA1cDAO() {
		return DAOFactory.getDAOFactory(DAOFactory.MYSQL).getA1cDAO();

	}

}
