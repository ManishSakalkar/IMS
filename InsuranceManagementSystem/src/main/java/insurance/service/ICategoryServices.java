package insurance.service;

import java.util.List;
import java.util.Optional;

import insurance.model.Category;

public interface ICategoryServices {

	Integer saveCategory(Category s);
	void updateCategory(Category s);
	
	void deleteCategory(Integer id);

	Optional<Category> getOneCategory(Integer id);
	List<Category> getAllCategorys();

	boolean isCategoryExist(Integer id);
}
