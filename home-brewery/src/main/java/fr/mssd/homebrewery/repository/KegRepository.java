package fr.mssd.homebrewery.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.mssd.homebrewery.model.Keg;
import fr.mssd.homebrewery.model.KegType;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface KegRepository extends CrudRepository<Keg, Integer> {

	@Query("SELECT k FROM Keg k WHERE k.kegType IS NULL")
	Collection<Keg> findAllUnregisteredKegs();
	
	@Query("SELECT k FROM Keg k WHERE k.kegType IS NOT NULL")
	Collection<Keg> findAllRegisteredKegs();
	
	@Query("SELECT k FROM Keg k WHERE k.vintage IS NOT NULL")
	Collection<Keg> findAllFilledKegs();
	
	@Query("SELECT k FROM Keg k WHERE k.kegType IS NOT NULL AND k.vintage IS NULL")
	Collection<Keg> findAllRegisteredAndEmptyKegs();
	
	//@Query(value = "SELECT k.kegType, b.name as vintage, count(*) as nbKeg FROM Keg k, Vintage v, BeerKit b WHERE k.vintage IS NOT NULL AND k.vintage = v.id AND v.beerKit = b.id GROUP BY k.kegType, b.name")
	@Query(value = "SELECT k.keg_type as kegType, b.name as vintage, count(*) as nbKeg FROM keg k, vintage v, beer_kit b WHERE k.vintage_id IS NOT NULL AND k.vintage_id = v.id AND v.beer_kit_id = b.id GROUP BY k.keg_type, b.name", nativeQuery = true)
	Collection<NbKegByVintage> getNbKegByVintage();

   public static interface NbKegByVintage {

     String getKegType();

     String getVintage();
     
     Integer getNbKeg();

  }
}
