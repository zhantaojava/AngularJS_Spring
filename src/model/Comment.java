package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Comment implements java.io.Serializable{
	@Id
	@Column(name = "c_id", unique = true, nullable = false)
	private int id;
	
	@Column
	private String text;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id", nullable = false)
	private Suggestion suggestion;
	
	@JsonBackReference
	public Suggestion getSuggestion() {
		return this.suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

	public Comment(){
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}