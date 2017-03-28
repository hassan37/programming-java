package b.beans._7settinglistproperties;

import java.util.List;

class FruitBasket {

	private String name;
	private List<String> fruits;
	
	public FruitBasket(String name, List<String> fruits) {
		this.name = name;
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		return "FruitBasket [name=" + name + ", fruits=" + fruits + "]";
	}

}
