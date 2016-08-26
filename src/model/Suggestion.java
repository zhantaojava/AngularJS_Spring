package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Suggestion implements java.io.Serializable {
	private int id;
	private String title;
	private Integer upVote;
	private Integer downVote;
	private String email;
	private String phoneNumber;
	private String address;
	private long openHour;
	private long closeHour;
	private String website;
	private Set<Comment> comments=new HashSet<Comment>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "suggestion")
	@JsonManagedReference
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public  int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column
	public Integer getUpVote() {
		return upVote;
	}

	public void setUpVote(Integer upVote) {
		this.upVote = upVote;
	}
	@Column
	public Integer getDownVote() {
		return downVote;
	}

	public void setDownVote(Integer downVote) {
		this.downVote = downVote;
	}
	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column
	public long getOpenHour() {
		return openHour;
	}

	public void setOpenHour(long openHour) {
		this.openHour = openHour;
	}
	@Column
	public long getCloseHour() {
		return closeHour;
	}

	public void setCloseHour(long closeHour) {
		this.closeHour = closeHour;
	}
	@Column
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	

}
