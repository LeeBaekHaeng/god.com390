package god.test.org.apache.commons.io;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtilsTest {

	protected Logger egovLogger = LoggerFactory.getLogger(FileUtilsTest.class);

	@Test
	public void test() {
//		File directory = new File(".");
		File directory = new File("../god.com");
//		File directory = new File("../egovframework-all-in-oneAllNew");
		String[] extensions = { "java" };
		boolean recursive = true;

		Collection<File> listFiles = FileUtils.listFiles(directory, extensions, recursive);

		egovLogger.debug("listFiles: {}", listFiles);
		egovLogger.debug("size: {}", listFiles.size());

		StringBuffer sb = new StringBuffer(SystemUtils.LINE_SEPARATOR);

		for (File listFile : listFiles) {
			egovLogger.debug("listFile: {}", listFile);

			String name = listFile.getName();

			egovLogger.debug("name: {}", name);

//			boolean endsWith = name.endsWith("Service.java");
			boolean endsWith = name.endsWith("ServiceImpl.java");

			if (endsWith) {
				sb.append(name);
				sb.append(SystemUtils.LINE_SEPARATOR);
			}
		}

		egovLogger.debug("{}", sb);
	}

}
