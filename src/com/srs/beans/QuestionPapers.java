package com.srs.beans;

import java.io.InputStream;

public class QuestionPapers {
	private String title;
	private String description;
	private InputStream inputsteam;
	private String type;
	private int id;
	
	public QuestionPapers(){}

	public QuestionPapers(int id, String title, String description,
			InputStream inputsteam,String type) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.inputsteam = inputsteam;
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InputStream getInputsteam() {
		return inputsteam;
	}

	public void setInputsteam(InputStream inputsteam) {
		this.inputsteam = inputsteam;
	}

	@Override
	public String toString() {
		return "QuestionPapers [title=" + title + ", description="
				+ description + ", inputsteam=" + inputsteam + ", type=" + type
				+ ", id=" + id + "]";
	}

	
	
}
