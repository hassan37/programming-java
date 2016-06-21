package pojo;


import util.WRUtil;

public class Word implements Comparable<Word> {

	private String value = "";

	private int occurence = 1;

	private int numOfLetters = 0;


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = WRUtil.prepareQualifiedWordValue(value);
	}

	public int getOccurence() {
		return occurence;
	}

	public void incrementOccurence() {
		this.occurence++;
	}

	public int getNumOfLetters() {
		return numOfLetters;
	}

	public void setNumOfLetters(int numOfLetters) {
		this.numOfLetters = numOfLetters;
	}


	@Override
	public String toString() {
		return "Word [value=" + value + ", occurence=" + occurence
				+ ", numOfLetters=" + numOfLetters + "]";
	}

	@Override
	public boolean equals(Object otherObj) {

		if (this == otherObj) {
			return true;
		}

		if (otherObj == null || otherObj.getClass() != this.getClass()) {
			return false;
		}

		Word otherWord = (Word) otherObj;

		return this.getValue().equals(otherWord.getValue());
	}

	public int compareTo(Word o) {
		int result = 0;

		if (this.getValue().length() > o.getValue().length()) {
			result = -1;
		} else if (this.getValue().length() < o.getValue().length()) {
			result = 1;
		}

		return result;
	}
}
