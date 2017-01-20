package videogen;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Utils {

	/**
	 * Generate a random number between 1 and borneSup.
	 *
	 * @param borneSup
	 * @return
	 */
	public final static int genRandomInt(final int borneSup) {
		return 1 + (int) (Math.random() * ((borneSup - 1) + 1));
	}


	public final static void fileWrite(final String filePath, final String content) {
		try {
			FileUtils.write(new File(filePath), content);
		} catch (IOException e) {
			throw new RuntimeException("Could not write content to file ["+filePath+"]",e);
		}
	}

	public final static void fileAppend(final String filePath, final String content) {
		try {
			FileUtils.write(new File(filePath), content, true);
		} catch (IOException e) {
			throw new RuntimeException("Could not append content to file ["+filePath+"]",e);
		}
	}
}
