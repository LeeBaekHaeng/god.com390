package model;

public class Entity extends NameCasing {

	public Entity(String name) {
		super(name);
	}

	private String tableComment;

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

}
