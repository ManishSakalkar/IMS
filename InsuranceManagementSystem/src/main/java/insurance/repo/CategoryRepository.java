package insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import insurance.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
