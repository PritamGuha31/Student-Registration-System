package com.srs.beans;

public class Books {
	private int bookid;
	private String bookname;
	private String author;
	private String subject;
	private String path;
	public Books() {}
	
	public Books(int bookid, String bookname, String author, String subject,
			String path) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = author;
		this.subject = subject;
		this.path = path;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookname=" + bookname
				+ ", author=" + author + ", subject=" + subject + ", path="
				+ path + "]";
	}
	
	
}
