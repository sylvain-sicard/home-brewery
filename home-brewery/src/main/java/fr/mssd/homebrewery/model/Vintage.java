package fr.mssd.homebrewery.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Vintage {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@OneToOne
	private BeerKit beerKit;
	private Date brewingDate;
	private String comment;
	private Boolean brewed = false;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BeerKit getBeerKit() {
		return beerKit;
	}
	public void setBeerKit(BeerKit beerKit) {
		this.beerKit = beerKit;
	}
	public Date getBrewingDate() {
		return brewingDate;
	}
	public void setBrewingDate(Date brewingDate) {
		this.brewingDate = brewingDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Boolean getBrewed() {
		return brewed;
	}
	public void setBrewed(Boolean brewed) {
		this.brewed = brewed;
	}
	
	
}
