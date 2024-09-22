package insurance.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import insurance.model.Manish;
import insurance.repo.ManishRepository;
import insurance.service.IManishServices;

@Service
public class ManishServiceImpl implements IManishServices {

	@Autowired
	private ManishRepository repo;
	
	@Override
	public Integer saveManish(Manish s) {
		s = repo.save(s);
		return s.getId();
	}

	@Override
	public void updateManish(Manish s) {
		repo.save(s);
	}

	@Override
	public void deleteManish(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Manish> getOneManish(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Manish> getAllManishs() {
		return repo.findAll();
	}

	@Override
	public boolean isManishExist(Integer id) {
		return repo.existsById(id);
	}

	
}
