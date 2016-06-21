package business;

import java.util.Collections;

import pojo.WordReportVO;
import util.WRCommonData;

public class LongestNumOfLetters implements Runnable {

	private WordReportVO wrVO = null;

	public LongestNumOfLetters(WordReportVO wr) {
		this.wrVO = wr;
	}

	@Override
	public void run() {
		Collections.sort(WRCommonData.shortestLtrsCountList);
		wrVO.setShortestLtrsCount(WRCommonData.shortestLtrsCountList.get(0));
		WRCommonData.shortestLtrsCountList.clear();
		WRCommonData.shortestLtrsCountList = null;
	}

}
