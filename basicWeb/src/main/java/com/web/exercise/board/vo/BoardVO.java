package com.web.exercise.board.vo;

public class BoardVO {

	private String id;
	private String title;
	private String contents;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", title=" + title + ", contents=" + contents + "]";
	}

}
