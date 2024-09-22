package insurance.service;

import java.util.List;

import java.util.Optional;

import insurance.model.Manish;


public interface IManishServices {

	Integer saveManish(Manish s);
	void updateManish(Manish s);
	
	void deleteManish(Integer id);

	Optional<Manish> getOneManish(Integer id);
	List<Manish> getAllManishs();

	boolean isManishExist(Integer id);
}
