package god.codegen.tables.service;

import java.util.List;

@SuppressWarnings("serial")
public class TablesVO extends Tables {

	private List<String> tableNames;

	public List<String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(List<String> tableNames) {
		this.tableNames = tableNames;
	}

}
