package at.fh.swenga.model;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
 
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class PlanetManager {
 
	private List<PlanetModel> planets = new ArrayList<PlanetModel>();
 
	/**
	 * Add planet to List
	 * @param planet
	 */
	public void addPlanet(PlanetModel planet) {
		planets.add(planet);
	}
 
	/**
	 * Verify if list contains planet with same id
	 * @param planet
	 * @return
	 */
	public boolean contains(PlanetModel planet) {
		return planets.contains(planet);
	}
	/**
	 * convenient method: true if list is empty
	 * @return
	 */
	public boolean isEmpty() {
		return planets.isEmpty();
	}
 
	/**
	 * try to find PlanetModel with given id
	 * return model, otherwise null
	 * @param id
	 * @return
	 */
	public PlanetModel getplanetByid(int id) {
		for (PlanetModel planet : planets) {
			if (planet.getId() == id) {
				return planet;
			}
		}
		return null;
	}
 
	/**
	 * return list with all planets
	 * @return
	 */
	public List<PlanetModel> getAllPlanets() {
		return planets;
	}
 
	/**
	 * return a new list with all planets where name or surface contains search string
	 * @param searchString
	 * @return
	 */
	public List<PlanetModel> getFilteredPlanets(String searchString) {
 
		if (searchString == null || searchString.equals("")) {
			return planets;
		}
 
		// List for results
		List<PlanetModel> filteredList = new ArrayList<PlanetModel>();
 
		// check every planet
		for (PlanetModel planetModel : planets) {
 
			if ((planetModel.getName() != null && planetModel.getName().contains(searchString))
					|| (planetModel.getSurface() != null && planetModel.getSurface().contains(searchString))) {
				filteredList.add(planetModel);
			}
		}
		return filteredList;
	}
 
	/**
	 * remove planets with same id
	 * @param id
	 * @return
	 */
	public boolean remove(int id) {
		return planets.remove(new PlanetModel(id, null, null));
	}
}