package fr.mssd.homebrewery.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;


@Entity 
@DiscriminatorValue(VintageType.BEER_STR)
public class BeerVintage extends Vintage{

	@OneToOne
	protected BeerKit beerKit;
	
	public BeerKit getBeerKit() {
		return beerKit;
	}
	public void setBeerKit(BeerKit beerKit) {
		this.beerKit = beerKit;
		name = beerKit.getName() + " (" + beerKit.getBeerType().toString() + ")";
	}
	
	public String getVintageType() {
		return VintageType.BEER_STR;
	}

	
}
