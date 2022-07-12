package com.tuff.api.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequence")
public class DatabaseSequence 
{
	@Id
	private String id;
	private int seq;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public DatabaseSequence() {}
	public DatabaseSequence(String id, int seq) {
		this.id = id;
		this.seq = seq;
	}
	
}
