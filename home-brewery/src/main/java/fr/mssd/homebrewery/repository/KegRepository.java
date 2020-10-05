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
	@Query(value = "SELECT kt.name as kegType, k.volume as kegVolume, v.name as vintage, count(*) as nbKeg, kt.icon FROM keg k, vintage v, keg_type kt WHERE k.vintage_id IS NOT NULL AND k.vintage_id = v.id AND k.keg_type_id = kt.id GROUP BY kt.name, k.volume, v.name, kt.icon ORDER BY v.name, kt.name, k.volume", nativeQuery = true)
	Collection<NbKegByVintage> getNbKegByVintage();

   public static interface NbKegByVintage {

     String getKegType();
     
     Float getKegVolume();

     String getVintage();
     
     Integer getNbKeg();
     
     String getIcon();

  }
}
