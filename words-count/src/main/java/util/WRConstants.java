package util;


/**
 * This is WordReportConstants Interface
 *
 * @author Hassan
 */
public interface WRConstants {

	String ALPHA_REGEX = "[A-Za-z]+([A-Za-z])*";

	String ALPHA_NUM_REGEX = "[A-Za-z0-9]+([A-Za-z0-9])*";

	String APOSTROPHE_WORD_REGEX = "[A-Za-z0-9]+([A-Za-z0-9])*['][sS]";

	String FILE_PATH = "user.dir";

	String FILE_NAME = "file.txt";

	int FILE_READER_POOL_SIZE = 100;

	String NUM_REGEX = "[0-9]+([0-9])*";

	String NEW_LINE_CHAR = "\n";

	int OTHER_FEATURE_POOL_SIZE = 2;

	int UN_PROCESSED_LINES_LIMIT = 500;
}