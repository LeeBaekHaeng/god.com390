package god.codegen;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.Globals;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.codegen.columns.service.ColumnsVO;
import god.codegen.columns.service.GodColumnsService;
import god.codegen.tables.service.GodTablesService;
import god.codegen.tables.service.TablesVO;
import model.Attribute;
import model.DataModelContext;
import model.Entity;
import operation.CrudCodeGen;

public class GodCrudCodeGenTest_a2_ibatis extends GodTestAbstract {

	protected Logger egovLogger = LoggerFactory.getLogger(GodCrudCodeGenTest_a2_ibatis.class);

	private CrudCodeGen crudCodeGen;
//	private DataModelContext dataModel;

	@Autowired
	private GodTablesService godTablesService;

	@Autowired
	private GodColumnsService godColumnsService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("CRUD 프로그램 자동 생성 기능 테스트");

		crudCodeGen = new CrudCodeGen();

		TablesVO vo = new TablesVO();
		vo.setTableSchema("com");
//		vo.setTableName("comtcadministcode");

		List<String> tableNames = new ArrayList<>();
		tableNames.add("comtcadministcode");
		tableNames.add("comtcadministcoderecptnlog");
		vo.setTableNames(tableNames);

		List<EgovMap> tables = godTablesService.selectList(vo);

		ColumnsVO columnsVO = new ColumnsVO();
		columnsVO.setTableSchema(vo.getTableSchema());
		columnsVO.setTableNames(tableNames);
		List<EgovMap> columns = godColumnsService.selectList(columnsVO);

		for (EgovMap table : tables) {
			String tableSchema = MapUtils.getString(table, "tableSchema");
			String tableName = MapUtils.getString(table, "tableName");
			String tableComment = MapUtils.getString(table, "tableComment");
			egovLogger.debug("tableSchema: {}", tableSchema);
			egovLogger.debug("tableName: {}", tableName);
			egovLogger.debug("tableComment: {}", tableComment);

			DataModelContext dataModel = new DataModelContext();
			Entity entity = new Entity(tableName);
			entity.setTableComment(tableComment);
			dataModel.setEntity(entity);

			List<Attribute> attributes = new ArrayList<Attribute>();
			List<Attribute> primaryKeys = new ArrayList<Attribute>();

			for (EgovMap column : columns) {
				String tableSchemaColumn = MapUtils.getString(column, "tableSchema");
				String tableNameColumn = MapUtils.getString(column, "tableName");
				String tableCommentColumn = MapUtils.getString(column, "tableComment");
				String columnName = MapUtils.getString(column, "columnName");
				String dataType = MapUtils.getString(column, "dataType");
				String columnType = MapUtils.getString(column, "columnType");
				String columnKey = MapUtils.getString(column, "columnKey");
				String columnComment = MapUtils.getString(column, "columnComment");
				egovLogger.debug("tableSchemaColumn: {}", tableSchemaColumn);
				egovLogger.debug("tableNameColumn: {}", tableNameColumn);
				egovLogger.debug("tableCommentColumn: {}", tableCommentColumn);
				egovLogger.debug("columnName: {}", columnName);

				if (tableSchema.equals(tableSchemaColumn) && tableName.equals(tableNameColumn)) {
					Attribute attr = new Attribute(columnName);
					attr.setType(dataType);
					attr.setJavaType(getDataType(dataType));
					attr.setColumnType(columnType);
					attr.setColumnKey(columnKey);
					attr.setColumnComment(columnComment);
					attributes.add(attr);

					if ("PRI".equals(columnKey)) {
						primaryKeys.add(attr);
					}
				}
			}

			dataModel.setAttributes(attributes);
			dataModel.setPrimaryKeys(primaryKeys);

			String result = generate(dataModel, "eGovFrameTemplates/crud/resource/pkg/EgovSample_Sample2_SQL.vm");

			writeStringToFile(dataModel, tableSchema, result);
		}

		egovLogger.debug("Globals.DB_TYPE: {}", Globals.DB_TYPE);
	}

	private String getDataType(String dataType) {
		if ("decimal".equals(dataType)) {
			return "int";
		} else {
			return "String";
		}
	}

	private String generate(DataModelContext dataModel, String templateFile) {
		try {
			return crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

	private void writeStringToFile(DataModelContext dataModel, String tableSchema, String result) {
		String pathname = SystemUtils.USER_HOME + SystemUtils.FILE_SEPARATOR + "Desktop" + SystemUtils.FILE_SEPARATOR
				+ "god.codegen" + SystemUtils.FILE_SEPARATOR + tableSchema + SystemUtils.FILE_SEPARATOR
				+ dataModel.getEntity().getName() + SystemUtils.FILE_SEPARATOR + dataModel.getEntity().getPcName()
				+ "_SQL_" + Globals.DB_TYPE + ".xml";
		egovLogger.debug("pathname: {}", pathname);

		File file = new File(pathname);
		String data = result;
		Charset encoding = StandardCharsets.UTF_8;
		egovLogger.debug("name: {}", encoding.name());

//		try {
//			FileUtils.writeStringToFile(file, data, encoding);
//		} catch (IOException e) {
//			egovLogger.error(e.getMessage());
//		}
	}

//	public void test2() throws Exception {
//		crudCodeGen = new CrudCodeGen();
//
//		dataModel = new DataModelContext();
//
//		dataModel.setPackageName("pkg");
//		dataModel.setAuthor("홍길동");
//		dataModel.setTeam("실행환경 개발팀");
//		dataModel.setCreateDate("2009.02.01");
//
//		Entity entity = new Entity("SAMPLE2");
//
//		dataModel.setEntity(entity);
//
//		List<Attribute> attributes = new ArrayList<Attribute>();
//		List<Attribute> primaryKeys = new ArrayList<Attribute>();
//
//		Attribute attr = new Attribute("ID");
//		attr.setJavaType("String");
//		attributes.add(attr);
//		primaryKeys.add(attr);
//
//		attr = new Attribute("NAME");
//		attr.setJavaType("String");
//		attributes.add(attr);
////		primaryKeys.add(attr);
//
//		attr = new Attribute("DESCRIPTION");
//		attr.setJavaType("String");
//		attributes.add(attr);
//
//		attr = new Attribute("USE_YN");
//		attr.setJavaType("String");
//		attributes.add(attr);
//
//		attr = new Attribute("REG_USER");
//		attr.setJavaType("String");
//		attributes.add(attr);
//
//		dataModel.setAttributes(attributes);
//		dataModel.setPrimaryKeys(primaryKeys);
//
//		String templateFile = "templates/crud/src/main/resources/pkg/EgovSample_Sample2_SQL.vm";
//		String result = crudCodeGen.generate(dataModel, templateFile);
//
////		egovLogger.debug("result: {}", result);
//
//		egovLogger.debug("USER_HOME: {}", SystemUtils.USER_HOME);
//
//		String today = EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null);
//
//		String pathname = SystemUtils.USER_HOME + SystemUtils.FILE_SEPARATOR + "Desktop" + SystemUtils.FILE_SEPARATOR
//				+ "god.codegen" + SystemUtils.FILE_SEPARATOR + today + SystemUtils.FILE_SEPARATOR
//				+ "EgovSample_Sample2_SQL.xml";
//		egovLogger.debug("pathname: {}", pathname);
//
//		File file = new File(pathname);
//		String data = result;
//		String encoding = "utf-8";
//		FileUtils.writeStringToFile(file, data, encoding);
//	}

}
