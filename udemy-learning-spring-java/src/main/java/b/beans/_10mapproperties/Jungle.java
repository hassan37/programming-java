package b.beans._10mapproperties;

import java.util.Map;

class Jungle {

	private Map<String,String> foods;

	public Map<String, String> getFoods() { return foods; }
	public void setFoods(Map<String, String> foods) { this.foods = foods; }

	@Override
	public String toString() {
		return "Jungle [foods=" + foods + "]";
	}

}
