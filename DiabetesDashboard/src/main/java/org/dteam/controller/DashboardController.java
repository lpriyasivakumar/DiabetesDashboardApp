package org.dteam.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.dteam.utilities.CookieUtil.*;
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

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String viewDashboard(Map<String, Object> model, HttpServletRequest request)
			throws UnsupportedEncodingException {

		if (getUserInfo(request, "id") == null || getUserInfo(request, "id").isEmpty()) {
			return "login";
		} else {
			String dateRange = request.getParameter("dateRange");
			Reading readingForm = new Reading();
			if (dateRange == null || dateRange.isEmpty()) {
				dateRange = "all";
			}
			getChartData(request, dateRange);
			model.put("dates", dates);
			model.put("bloodGlucose", bloodGlucose);
			model.put("insulin", insulin);
			model.put("readingForm", readingForm);
			model.put("userName", URLDecoder.decode(getUserInfo(request, "user"),
					java.nio.charset.StandardCharsets.UTF_8.toString()));
			model.put("url", getUserInfo(request, "image"));
			return "dashboard";
		}

	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String doDashboard(@ModelAttribute("readingForm") Reading reading, BindingResult result, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ReadingDAO readingDAO = getDAO();
		String userID = getUserInfo(request, "id");
		int result1 = readingDAO.addReading(reading, userID);
		if (result1 > 0)
			model.addAttribute("Msg", result1 + " reading added.");
		else
			model.addAttribute("Msg", "Invalid entries. Cannot save reading");
		return "dashboard";
	}

	private void getChartData(HttpServletRequest request, String dateRange) {
		ArrayList<String> dateArray = new ArrayList<String>();
		ArrayList<Integer> bgArray = new ArrayList<Integer>();
		ArrayList<Integer> insulinArray = new ArrayList<Integer>();
		String userID = getUserInfo(request, "id");
		ReadingDAO readingDAO = getDAO();
		ArrayList<Reading> readings = readingDAO.getReadings(dateRange, userID);
		for (Reading reading : readings) {
			dateArray.add(reading.getDate());
			bgArray.add(reading.getBloodGlucose());
			insulinArray.add(reading.getInsulin());
		}
		dates = JsonArrayMaker.makeJsonArray(dateArray);
		bloodGlucose = JsonArrayMaker.makeJsonArray(bgArray);
		insulin = JsonArrayMaker.makeJsonArray(insulinArray);
	}

	public ReadingDAO getDAO() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReadingDAO readingDAO = mysqlFactory.getReadingDAO();
		return readingDAO;

	}

}
