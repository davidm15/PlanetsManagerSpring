package at.fh.swenga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.model.PlanetManager;
import at.fh.swenga.model.PlanetModel;

@Controller
public class PlanetManagerController {

	@Autowired
	PlanetManager planetManager;
	
	@RequestMapping(value = { "/", "planets" })
	public String showAllPlanets(Model planet) {
		planet.addAttribute("planets", planetManager.getAllPlanets());
		return "planets";
	}
	
	@RequestMapping("/fillplanetlist")
	public String fillPlanetList() {
 
		planetManager.addPlanet(new PlanetModel(1, "Earth", "Blue", 40000));
		planetManager.addPlanet(new PlanetModel(2, "Mars", "Red", 35000));
		planetManager.addPlanet(new PlanetModel(3, "Saturn", "Brown", 100000));
		
		return "forward:/listplanets";
 
	}
	
	@RequestMapping("/deleteplanet")
	public String delete(Model model, @RequestParam int id) {
		boolean isRemoved = planetManager.remove(id);
 
		if (isRemoved) {
			model.addAttribute("warningMessage", "planet " + id + " deleted");
		} else {
			model.addAttribute("errorMessage", "There is no planet " + id);
		}
 
		// Multiple ways to "forward" to another Method
		// return "forward:/listplanets";
		return showAllPlanets(model);
	}
	
	@RequestMapping("/searchplanets")
	public String search(Model model, @RequestParam String searchString) {
		model.addAttribute("planets", planetManager.getFilteredPlanets(searchString));
		return "employees";
	}
	
	@RequestMapping(value = "/addplanet", method = RequestMethod.GET)
	public String showAddPlanetForm(PlanetModel model) {
		return "editplanet";
	}
	
	
}
