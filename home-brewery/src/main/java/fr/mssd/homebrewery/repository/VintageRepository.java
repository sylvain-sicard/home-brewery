package fr.mssd.homebrewery.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.mssd.homebrewery.model.Vintage;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface VintageRepository extends CrudRepository<Vintage, Integer> {
	
	@Query("SELECT v FROM Vintage v WHERE v.brewed = FALSE")
	Collection<Vintage> findAllVintagesNotBrewed();
	
	@Query("SELECT v FROM Vintage v WHERE v.brewed = FALSE")
	Vintage findUniqueVintageNotBrewed();

}
