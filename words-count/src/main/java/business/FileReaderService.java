package business;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

import pojo.BaseService;
import pojo.WordReportVO;
import util.WRCommonData;
import util.WRConstants;
import util.WRUtil;

public class FileReaderService implements BaseService {

	private WordReportVO wrVO = null;

	public FileReaderService(final WordReportVO wrVO) {
		this.wrVO = wrVO;
	}

	@Override
	public void doService(Object... args) throws IllegalArgumentException, Exception {
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		WRUtil.print("FilereaderService is srated at: " + startTime);

		if (null == args || args.length < 1) {
			throw new IllegalArgumentException(
					"No parameter is provided to start. Expected Parameter is: a complete file path");
		} else {
			String filePath = null;

			if (!(args[0] instanceof String) || WRUtil.isNullOrEmptyStr((filePath = (String) args[0]))) {
				throw new IllegalArgumentException(
						"No parameter is provided to start. Expected Parameter is: a complete file path");
			} else {
				try {
					readLargerTextFile(filePath);
				} catch (IOException e) {
					throw new Exception(e);
				} catch (InvalidPathException e) {
					throw new Exception(e);
				}
			}
		}

		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		WRUtil.print("FilereaderService is ended  at: " + endTime);
		WRUtil.print("\nFilereaderService has taken total time: " + (endTime.getTime() - startTime.getTime()) + " mili seconds.\n");
	}

	/**
	 * This method is used to read larger files
	 *
	 * @param fileCompletePath
	 * @throws IOException
	 * @throws InvalidPathException
	 * @author Hassan
	 * @since Oct 18, 2013
	 */
	private void readLargerTextFile(final String fileCompletePath) throws IOException, InvalidPathException, Exception {

		//1. Read the file
		BufferedReader reader = null;
		Path path = null;

		try {
			path = Paths.get(fileCompletePath);

			reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			StringBuilder fileContents = new StringBuilder("");
			String line = null;
			int unProcessedLinesCounter = 0;
			int newLineCharCount = 0;
			double totalLettersUsed = 0;

			while ((line = reader.readLine()) != null) {

				//2. increment the frequency of new line character
				newLineCharCount++;
				unProcessedLinesCounter++;
				totalLettersUsed += (line.length() + 1);

				//3. append the line
				fileContents.append(line);
				fileContents.append(WRConstants.NEW_LINE_CHAR);

				//4. increment and check the unprocessed line counter
				if (unProcessedLinesCounter == WRConstants.UN_PROCESSED_LINES_LIMIT) {

					//5. set the counter back to zero
					unProcessedLinesCounter = 0;

					//6. start new line processor thread
					LineProcessor lp = new LineProcessor(fileContents.toString(), wrVO);
					WRCommonData.fileReaderPool.execute(lp);

					//7. clean the contents in string builder
					fileContents = null;
					fileContents = new StringBuilder("");
				}
			}// while loop ends here

			if (unProcessedLinesCounter > 0 && !WRUtil.isNullOrEmptyStr(fileContents.toString())) {
				LineProcessor lp = new LineProcessor(fileContents.toString(), wrVO);
				WRCommonData.fileReaderPool.execute(lp);
			}

			wrVO.setNewLineCharCount(newLineCharCount);
			wrVO.setTotalLettersUsed(totalLettersUsed);
		} catch (MalformedInputException e) {
			throw new Exception("File encoding is not supported. Only [UTF_8] is supported. Exception Occured due to: " + e);
		} catch (Exception e) {
			throw e;
		} finally {
			if (null != reader) {
				reader.close();
			}
		}
	}

}
