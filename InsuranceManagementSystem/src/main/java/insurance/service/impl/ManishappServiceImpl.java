package insurance.service.impl;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import insurance.model.Manishapp;
import insurance.repo.ManishappRepository;
import insurance.service.IManishappServices;

@Service
public class ManishappServiceImpl implements IManishappServices {

	@Autowired
	private ManishappRepository repo;
	
	@Override
	public Integer saveManishapp(Manishapp s) {
		s = repo.save(s);
		return s.getId();
	}

	@Override
	public void updateManishapp(Manishapp s) {
		repo.save(s);
	}

	@Override
	public void deleteManishapp(Integer id) {
		repo.deleteById(id);
	}
	

	@Override
	public Optional<Manishapp> getOneManishapp(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Manishapp> getAllManishapps() {
		return repo.findAll();
	}

	@Override
	public boolean isManishappExist(Integer id) {
		return repo.existsById(id);
	}

	
}
