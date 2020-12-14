package egovframework.com.cmm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.FileVO;

@Repository
public class FileManageDAOTest {

	protected Logger egovLogger = LoggerFactory.getLogger(FileManageDAOTest.class);

	private final FileManageDAO fileManageDAO;

	public FileManageDAOTest(FileManageDAO fileManageDAO) {
		this.fileManageDAO = fileManageDAO;
	}

	public void updateFileInfs(List<?> fileList) {
		try {
			fileManageDAO.updateFileInfs(fileList);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

	public int getMaxFileSN(FileVO fvo) {
		try {
			return fileManageDAO.getMaxFileSN(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return 0;
		}
	}

	public void deleteFileInfs(List<?> fileList) {
		try {
			fileManageDAO.deleteFileInfs(fileList);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

	public void deleteFileInf(FileVO fvo) {
		try {
			fileManageDAO.deleteFileInf(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
