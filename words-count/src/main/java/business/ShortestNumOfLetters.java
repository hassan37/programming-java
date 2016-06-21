package business;

import java.util.Collections;

import pojo.WordReportVO;
import util.WRCommonData;

public class ShortestNumOfLetters implements Runnable {
	private WordReportVO wrVO = null;

	public ShortestNumOfLetters(WordReportVO wr) {
		this.wrVO = wr;
	}

	@Override
	public void run() {
		Collections.sort(WRCommonData.LongesttLtrsCountList);
		wrVO.setLongestLtrsCount(WRCommonData.LongesttLtrsCountList.get(
				(WRCommonData.LongesttLtrsCountList.size() - 1)));
		WRCommonData.LongesttLtrsCountList.clear();
		WRCommonData.LongesttLtrsCountList = null;
	}

}
