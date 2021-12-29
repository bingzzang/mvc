package com.bing.model;

import java.util.Date;

public class BoardVO {

	private int idx;
	private String title;
	private String contents;
	private int readcount;
	private String writer;
	private Date indate;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", title=" + title + ", contents=" + contents + ", readcount=" + readcount
				+ ", writer=" + writer + ", indate=" + indate + "]";
	}

}
