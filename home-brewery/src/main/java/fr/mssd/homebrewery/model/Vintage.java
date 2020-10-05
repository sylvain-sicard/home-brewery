package fr.mssd.homebrewery.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="vintageType", 
  discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(VintageType.GENERIC_STR)
public class Vintage {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	protected Date brewingDate;
	protected String comment;
	protected Boolean brewed = false;
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public String getVintageType() {
		return VintageType.GENERIC_STR;
	}
}
