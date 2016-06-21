package business;

import pojo.Word;
import pojo.WordReportVO;
import util.WRCommonData;
import util.WRUtil;

public class LineProcessor implements Runnable {

	private String linesToProcess = "";

	private WordReportVO wrVO = null;

	public LineProcessor(final String lines, final WordReportVO wrVO) {
		this.linesToProcess = lines;
		this.wrVO = wrVO;
	}


	public void run() {

		int shortestNumOfLtrs = 0;
		int longestNumOfLtrs = 0;
		double lettersCount = 0;

		if (!WRUtil.isNullOrEmptyStr(linesToProcess)) {

			// 1. first of all replace all '.' from the lines
			linesToProcess = linesToProcess.replace(".", " ");

			// 2. get a single new line to process
			String[] linesArr = linesToProcess.split("[\n]");

			// 3. get a single word
			for (String line : linesArr) {
				String[] wordArr = line.split("\\s");

				// 4. process the single word
				for (String word : wordArr) {
					if (WRUtil.isThisAQualifiedWord(word)) {
						Word w = new Word();
						w.setNumOfLetters(word.length());
						w.setValue(word);

						//5. add new word to the map
						if (WRCommonData.wordsMap.containsKey(w.getValue())) {
							WRCommonData.wordsMap.get(w.getValue()).incrementOccurence();
						} else {
							WRCommonData.wordsMap.put(w.getValue(), w);
							int length = w.getValue().length();

							if (shortestNumOfLtrs != 0) {
								if (shortestNumOfLtrs > length) {
									shortestNumOfLtrs = length;
								} else if (longestNumOfLtrs < length) {
									longestNumOfLtrs = length;
								}
							} else {
								shortestNumOfLtrs = length;
								longestNumOfLtrs = length;
							}
						}
					}
					//6. increment the letters frequency
					lettersCount += word.length();
				}
			}

		}// main if ends here
		else {
			WRUtil.print("provided lines to proces are either empty or null");
		}

		if (shortestNumOfLtrs > 0) {
			WRCommonData.shortestLtrsCountList.add(shortestNumOfLtrs);
		}

		if (longestNumOfLtrs > 0) {
			WRCommonData.LongesttLtrsCountList.add(longestNumOfLtrs);
		}
		wrVO.setLettersCount(lettersCount);

		linesToProcess = null;
	}
}
