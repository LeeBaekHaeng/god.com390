package god.test.a1.service;

import egovframework.com.cmm.ComDefaultVO;

@SuppressWarnings("serial")
public class A1VO extends ComDefaultVO {

	public String tableSchema;
	public String tableName;
	public String tableComment;

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

}
