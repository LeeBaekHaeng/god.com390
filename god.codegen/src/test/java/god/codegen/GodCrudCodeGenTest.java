package god.codegen;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.string.EgovDateUtil;
import model.Attribute;
import model.DataModelContext;
import model.Entity;
import operation.CrudCodeGen;

public class GodCrudCodeGenTest {

	protected Logger egovLogger = LoggerFactory.getLogger(GodCrudCodeGenTest.class);

	private CrudCodeGen crudCodeGen;
	private DataModelContext dataModel;

	@Test
	public void test() throws Exception {
		egovLogger.debug("CRUD 프로그램 자동 생성 기능 테스트");

		crudCodeGen = new CrudCodeGen();

		dataModel = new DataModelContext();

		dataModel.setPackageName("pkg");
		dataModel.setAuthor("홍길동");
		dataModel.setTeam("실행환경 개발팀");
		dataModel.setCreateDate("2009.02.01");

		Entity entity = new Entity("SAMPLE2");

		dataModel.setEntity(entity);

		List<Attribute> attributes = new ArrayList<Attribute>();
		List<Attribute> primaryKeys = new ArrayList<Attribute>();

		Attribute attr = new Attribute("ID");
		attr.setJavaType("String");
		attributes.add(attr);
		primaryKeys.add(attr);

		attr = new Attribute("NAME");
		attr.setJavaType("String");
		attributes.add(attr);
//		primaryKeys.add(attr);

		attr = new Attribute("DESCRIPTION");
		attr.setJavaType("String");
		attributes.add(attr);

		attr = new Attribute("USE_YN");
		attr.setJavaType("String");
		attributes.add(attr);

		attr = new Attribute("REG_USER");
		attr.setJavaType("String");
		attributes.add(attr);

		dataModel.setAttributes(attributes);
		dataModel.setPrimaryKeys(primaryKeys);

		String templateFile = "templates/crud/src/main/resources/pkg/EgovSample_Sample2_SQL.vm";
		String result = crudCodeGen.generate(dataModel, templateFile);

//		egovLogger.debug("result: {}", result);

		egovLogger.debug("USER_HOME: {}", SystemUtils.USER_HOME);

		String today = EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null);

		String pathname = SystemUtils.USER_HOME + SystemUtils.FILE_SEPARATOR + "Desktop" + SystemUtils.FILE_SEPARATOR
				+ "god.codegen" + SystemUtils.FILE_SEPARATOR + today + SystemUtils.FILE_SEPARATOR
				+ "EgovSample_Sample2_SQL.xml";
		egovLogger.debug("pathname: {}", pathname);

		File file = new File(pathname);
		String data = result;
		String encoding = "utf-8";
		FileUtils.writeStringToFile(file, data, encoding);
	}

}
