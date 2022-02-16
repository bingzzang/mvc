package com.web.exercise.test.vo;

/**
 * test board vo
 */
public class TestBoardVo {

	private String title;
	private String content;
	private String writer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "TestBoardVo [title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}

}
