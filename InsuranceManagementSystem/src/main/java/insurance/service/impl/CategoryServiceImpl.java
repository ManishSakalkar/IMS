package insurance.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import insurance.model.Category;
import insurance.repo.CategoryRepository;
import insurance.service.ICategoryServices;

@Service
public class CategoryServiceImpl implements ICategoryServices {

	@Autowired
	private CategoryRepository repo;
	
	@Override
	public Integer saveCategory(Category s) {
		s = repo.save(s);
		return s.getId();
	}

	@Override
	public void updateCategory(Category s) {
		repo.save(s);
	}

	@Override
	public void deleteCategory(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Category> getOneCategory(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Category> getAllCategorys() {
		return repo.findAll();
	}

	@Override
	public boolean isCategoryExist(Integer id) {
		return repo.existsById(id);
	}

	
}
