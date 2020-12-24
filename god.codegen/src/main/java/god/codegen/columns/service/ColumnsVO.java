package god.codegen.columns.service;

import java.util.List;

@SuppressWarnings("serial")
public class ColumnsVO extends Columns {

	public List<String> tableNames;

	public List<String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(List<String> tableNames) {
		this.tableNames = tableNames;
	}

}
