package org.dteam.utilities;

import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class JsonArrayMaker {

	public static <T> String makeJsonArray(Collection<T> list) {
		Gson gson = new GsonBuilder().create();
		JsonArray jsonArray = gson.toJsonTree(list).getAsJsonArray();

		return jsonArray.toString();
	}

}
