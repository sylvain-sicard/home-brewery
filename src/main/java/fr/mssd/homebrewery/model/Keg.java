package fr.mssd.homebrewery.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Keg {
	@Id
	private Integer id;

	private Float volume;
	
	@OneToOne
	private Vintage vintage;
	
	private Date fillingDate;
	
	@OneToOne
	private KegType kegType;

	public Keg() {}
	
	public Keg(Integer id) {
		this.id=id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	public Vintage getVintage() {
		return vintage;
	}

	public void setVintage(Vintage vintage) {
		this.vintage = vintage;
	}

	public Date getFillingDate() {
		return fillingDate;
	}

	public void setFillingDate(Date fillingDate) {
		this.fillingDate = fillingDate;
	}

	public KegType getKegType() {
		return kegType;
	}

	public void setKegType(KegType kegType) {
		this.kegType = kegType;
	}
	
	
}
