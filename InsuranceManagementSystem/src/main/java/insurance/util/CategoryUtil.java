package insurance.util;

import org.springframework.stereotype.Component;


import insurance.model.Category;

@Component
public class CategoryUtil {

	public void mapToActualObject(Category actual, Category category) {
		if(category.getCategoryname()!=null)
			actual.setCategoryname(category.getCategoryname());
			if(category.getCreationdate()!=null)
			actual.setCreationdate(category.getCreationdate());
	}

}
