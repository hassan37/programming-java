package b.beans._11arbitrarymapsasbeanproperties;

import java.util.Map;

class Jungle {

	private Map<String,String> foods;
	private Map<String,Animal> animals;

	public Map<String, String> getFoods() { return foods; }
	public void setFoods(Map<String, String> foods) { this.foods = foods; }

	public Map<String, Animal> getAnimals() { return animals; }
	public void setAnimals(Map<String, Animal> animals) { this.animals = animals; }

	@Override
	public String toString() {
		return "Jungle [foods=" + foods + ", animals=" + animals + "]";
	}
}
