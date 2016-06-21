package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pojo.Word;

public abstract class WRCommonData {

	public static ExecutorService fileReaderPool = Executors.newFixedThreadPool(WRConstants.FILE_READER_POOL_SIZE);

	public static ExecutorService otherFeaturePool = Executors.newFixedThreadPool(WRConstants.OTHER_FEATURE_POOL_SIZE);

	public static Map<String, Word> wordsMap = new HashMap<String, Word>(100);

	public static List<Integer> shortestLtrsCountList = new ArrayList<Integer>();

	public static List<Integer> LongesttLtrsCountList = new ArrayList<Integer>();
}
