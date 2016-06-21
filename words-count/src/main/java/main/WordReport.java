package main;

import java.io.File;
import java.util.Scanner;

import business.FileReaderService;
import business.LongestNumOfLetters;
import business.ShortestNumOfLetters;
import pojo.BaseService;
import pojo.WordReportVO;
import util.WRCommonData;
import util.WRConstants;
import util.WRUtil;
import view.UserView;

/**
 * This class is used to perform all word report actions
 *
 * @author Hassan
 * @since Oct 18, 2013
 */
public class WordReport {

	public static void main(String[] args) {

		WordReportVO wrVO = new WordReportVO();
		boolean exitNow = false;
		Scanner in = new Scanner(System.in);

		//1. Perform View operation
		displayTheMenu(in);

		//2. now start reading the file
		BaseService service = new FileReaderService(wrVO);
		try {
			service.doService((System.getProperty(WRConstants.FILE_PATH) + File.separator + args[0]));
		} catch (IllegalArgumentException e) {
			System.out.println("System is exitting due to: " + e);
			exitNow = true;
		} catch (Exception e) {
			System.out.println("System is exitting due to: " + e);
			exitNow = true;
		} finally {
			if (exitNow) {
				WRCommonData.fileReaderPool.shutdownNow();
				System.exit(0);
			}
		}

		//3. shut down file reader thread pool
		shutDownFileReaderPool();

		//4. shortest thread execution
		if (WRCommonData.shortestLtrsCountList.size() > 0) {
			ShortestNumOfLetters shThread = new ShortestNumOfLetters(wrVO);
			WRCommonData.otherFeaturePool.execute(shThread);
		}
		if (WRCommonData.LongesttLtrsCountList.size() > 0) {
			//5. longest thread execution
			LongestNumOfLetters loThread = new LongestNumOfLetters(wrVO);
			WRCommonData.otherFeaturePool.execute(loThread);
		}

		//6. shutdown the pool
		shutDownOtherFeaturePool();

		//7. now print the summary
		UserView.displaySummary(wrVO);

		//8. Now display the input search term menu
		displaySearchTermMenu(in);

		WRCommonData.wordsMap.clear();
		in.close();
	}


	private static void displayTheMenu(Scanner in) {
		UserView.printMainMenu();
		in.nextLine();
	}

	private static void displaySearchTermMenu(Scanner in) {
		String userInput = "";
		do {
			UserView.printSearchTermMenu();
			userInput = in.nextLine();

			if (WRUtil.isNullOrEmptyStr(userInput)) {
				WRUtil.print("Empty input.");
			} else {
				String qualifiedValue = WRUtil.prepareQualifiedWordValue(userInput);
				if ("q".equals(qualifiedValue)) {
					break;
				} else if (WRCommonData.wordsMap.containsKey(qualifiedValue)) {
					WRUtil.print("Number of times [" + userInput + "] appears: " +
							             WRCommonData.wordsMap.get(qualifiedValue).getOccurence());
				} else {
					WRUtil.print("No such qualified word exist in document.");
				}
			}

		} while (true);
	}


	private static void shutDownFileReaderPool() {
		WRCommonData.fileReaderPool.shutdown();
		while (!WRCommonData.fileReaderPool.isTerminated()) ;
		WRCommonData.fileReaderPool = null;
	}

	private static void shutDownOtherFeaturePool() {
		WRCommonData.otherFeaturePool.shutdown();
		while (!WRCommonData.otherFeaturePool.isTerminated()) ;
		WRCommonData.otherFeaturePool = null;
	}
}
