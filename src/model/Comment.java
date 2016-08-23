package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Comment {
	@Id
	private int id;
	@Column
	private String comment;
	
	
	public Comment(){
		
	}
	
	public Comment(int id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommon() {
		return comment;
	}
	public void setCommon(String comment) {
		this.comment = comment;
	}
}
