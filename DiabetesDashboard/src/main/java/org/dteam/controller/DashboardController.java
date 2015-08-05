package org.dteam.controller;

import java.io.UnsupportedEncodingException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dteam.dao.A1cDAO;
import org.dteam.dao.DAOFactory;
import org.dteam.dao.ReadingDAO;
import org.dteam.model.Reading;

import org.dteam.utilities.JsonArrayMaker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonArray;

@Controller
public class DashboardController {
	JsonArray dates;
	JsonArray bloodGlucose;
	JsonArray insulin;

	DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String viewDashboard(Map<String, Object> model, HttpServletRequest request)
			throws UnsupportedEncodingException {

		HttpSession session = request.getSession();
		String userID = session.getAttribute("userID").toString();
		if (userID == null || userID.isEmpty()) {

			return "login";
		} else {
			String dateRange = request.getParameter("dateRange");
			Reading readingForm = new Reading();
			A1cDAO a1cdao = mysqlFactory.getA1cDAO();
			double labA1c = a1cdao.getLabValue(userID);
			if (dateRange == null || dateRange.isEmpty()) {
				dateRange = "all";
			}
			getChartData(request, dateRange);
			model.put("dates", dates);
			model.put("bloodGlucose", bloodGlucose);
			model.put("insulin", insulin);
			model.put("readingForm", readingForm);

			model.put("userName", session.getAttribute("userName").toString());
			model.put("url", session.getAttribute("image").toString());
			model.put("labA1c", labA1c);

			return "dashboard";

		}

	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String doDashboard(@ModelAttribute("readingForm") Reading reading, BindingResult result, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {

		ReadingDAO readingDAO = mysqlFactory.getReadingDAO();
		HttpSession session = request.getSession();
		int result1 = readingDAO.addReading(reading, session.getAttribute("userID").toString());

		if (result1 > 0)
			model.addAttribute("Msg", result1 + " reading added.");
		else
			model.addAttribute("Msg", "Invalid entries. Cannot save reading");
		return "dashboard";
	}

	private void getChartData(HttpServletRequest request, String dateRange) {
		HttpSession session = request.getSession();
		ArrayList<String> dateArray = new ArrayList<String>();
		ArrayList<Integer> bgArray = new ArrayList<Integer>();

		ArrayList<Integer> insulinArray = new ArrayList<Integer>();
		ReadingDAO readingDAO = mysqlFactory.getReadingDAO();
		ArrayList<Reading> readings = readingDAO.getReadings(dateRange, session.getAttribute("userID").toString());

		for (Reading reading : readings) {
			dateArray.add(reading.getDate());
			bgArray.add(reading.getBloodGlucose());
			insulinArray.add(reading.getInsulin());
		}
		dates = JsonArrayMaker.makeJsonArray(dateArray);
		bloodGlucose = JsonArrayMaker.makeJsonArray(bgArray);
		insulin = JsonArrayMaker.makeJsonArray(insulinArray);
	}

}
