package fr.mssd.homebrewery.repository;

import org.springframework.data.repository.CrudRepository;

import fr.mssd.homebrewery.model.KegType;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface KegTypeRepository extends CrudRepository<KegType, Integer> {

}
