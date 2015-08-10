package org.dteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

	@RequestMapping("/recipe")
	public String viewRecipe() {
		return "recipe";
	}

}
