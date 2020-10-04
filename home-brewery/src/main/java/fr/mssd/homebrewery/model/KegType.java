package fr.mssd.homebrewery.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KegType {
	
	@Id
	protected String id;

	public KegType(String kegType) {
		super();
		this.id = kegType;
	}
	
	public KegType() {
	
	}
	public String getId() {
		return id;
	}

	public void setId(String kegType) {
		this.id = kegType;
	}

	
	
}
