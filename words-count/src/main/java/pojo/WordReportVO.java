package pojo;

public class WordReportVO {

	private int newLineCharCount = 0;

	private double lettersCount = 0;

	private double totalLettersUsed = 0;

	private int shortestLtrsCount = 0;

	private int longestLtrsCount = 0;


	public int getNewLineCharCount() {
		return newLineCharCount;
	}

	public void setNewLineCharCount(int newLineCharCount) {
		this.newLineCharCount = newLineCharCount;
	}

	public double getTotalLettersUsed() {
		return totalLettersUsed;
	}

	public void setTotalLettersUsed(double totalLettersUsed) {
		this.totalLettersUsed = totalLettersUsed;
	}

	public double getLettersCount() {
		return lettersCount;
	}

	public void setLettersCount(double lettersCount) {
		this.lettersCount += lettersCount;
	}

	public int getShortestLtrsCount() {
		return shortestLtrsCount;
	}

	public void setShortestLtrsCount(int shortestLtrsCount) {
		this.shortestLtrsCount = shortestLtrsCount;
	}

	public int getLongestLtrsCount() {
		return longestLtrsCount;
	}

	public void setLongestLtrsCount(int longestLtrsCount) {
		this.longestLtrsCount = longestLtrsCount;
	}

	@Override
	public String toString() {
		return "WordReportVO [newLineCharCount=" + newLineCharCount
				+ ", lettersCount=" + lettersCount + ", totalLettersUsed="
				+ totalLettersUsed + ", shortestLtrsCount=" + shortestLtrsCount
				+ ", longestLtrsCount=" + longestLtrsCount + "]";
	}

}
