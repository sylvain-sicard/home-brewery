package fr.mssd.homebrewery.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.mssd.homebrewery.model.BeerKit;
import fr.mssd.homebrewery.model.Keg;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BeerKitRepository extends CrudRepository<BeerKit, Integer> {
	
	@Query("SELECT b FROM BeerKit b WHERE EXISTS (SELECT v FROM Vintage v WHERE b.id = v.beerKit)")
	Collection<BeerKit> findAllBrewed();
	
	@Query("SELECT b FROM BeerKit b WHERE NOT EXISTS (SELECT v FROM Vintage v WHERE b.id = v.beerKit)")
	Collection<BeerKit> findAllAvailable();

}
