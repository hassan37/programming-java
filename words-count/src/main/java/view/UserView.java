package view;

import pojo.WordReportVO;
import util.WRCommonData;
import util.WRConstants;
import util.WRUtil;

public abstract class UserView {

	public static void printMainMenu() {
		WRUtil.print(
				"/*** Starting Word Report Utlity ***/\n\nPress any button to Start reading the document and showing its summary...");
	}

	public static void printSearchTermMenu() {
		WRUtil.print("input search term: ");
	}

	public static void displaySummary(final WordReportVO wrVO) {
		StringBuilder summary = new StringBuilder("");
		summary.append("\n/*** Starting Word Report Summary ***/\n\n");

		summary.append("Total words count: ");
		summary.append(WRCommonData.wordsMap.size());
		summary.append(WRConstants.NEW_LINE_CHAR);

		summary.append("Total New Line Character count: ");
		summary.append(wrVO.getNewLineCharCount());
		summary.append(WRConstants.NEW_LINE_CHAR);

		summary.append("Total Number of Letters count: ");
		summary.append(wrVO.getTotalLettersUsed());
		summary.append(WRConstants.NEW_LINE_CHAR);

		summary.append("Avg Number of Letters used: ");
		double avgLetterFreq = wrVO.getTotalLettersUsed() / (0 != wrVO.getLettersCount() ? wrVO.getLettersCount() : 1);
		avgLetterFreq = Math.round(avgLetterFreq * 100) / 100.00;
		summary.append(avgLetterFreq);
		summary.append(WRConstants.NEW_LINE_CHAR);

		summary.append("Shortest no of letters: ");
		summary.append(wrVO.getShortestLtrsCount());
		summary.append(WRConstants.NEW_LINE_CHAR);

		summary.append("Longest no of letters: ");
		summary.append(wrVO.getLongestLtrsCount());
		summary.append(WRConstants.NEW_LINE_CHAR);

		summary.append("\n/*** Word Report Summary Ended ***/\n");

		System.out.println(summary.toString());
	}

}
