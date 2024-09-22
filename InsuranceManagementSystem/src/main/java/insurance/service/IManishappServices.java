package insurance.service;

import java.util.List;

import java.util.Optional;

import insurance.model.Manishapp;


public interface IManishappServices {

	Integer saveManishapp(Manishapp s);
	void updateManishapp(Manishapp s);
	
	void deleteManishapp(Integer id);
	

	Optional<Manishapp> getOneManishapp(Integer id);
	List<Manishapp> getAllManishapps();

	boolean isManishappExist(Integer id);
}
