package at.fh.swenga.model;

import java.util.List;

public class PlanetModel implements Comparable<PlanetModel> {

	private int id;
	private String name;
	private String surface;
	private float size;
	
	public PlanetModel() {
		
	}
	
	public PlanetModel(int id, String name, String surface) {
		super();
		this.id = id;
		this.name = name;
		this.surface = surface;
	}
	
	public PlanetModel(int id, String name, String surface, float size) {
		super();
		this.id = id;
		this.name = name;
		this.surface = surface;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanetModel other = (PlanetModel) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public int compareTo(PlanetModel o) {
		return id - o.getId();
	}
	
	
}
