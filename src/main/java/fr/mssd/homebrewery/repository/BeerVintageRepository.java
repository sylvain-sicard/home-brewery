package fr.mssd.homebrewery.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.mssd.homebrewery.model.BeerVintage;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BeerVintageRepository extends CrudRepository<BeerVintage, Integer> {
	
	@Query("SELECT v FROM Vintage v WHERE v.brewed = FALSE")
	Collection<BeerVintage> findAllVintagesNotBrewed();
	
	@Query("SELECT v FROM Vintage v WHERE v.brewed = FALSE")
	BeerVintage findUniqueVintageNotBrewed();

}
