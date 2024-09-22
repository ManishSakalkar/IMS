package insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import insurance.model.Problem;

public interface ProblemRepository extends JpaRepository<Problem, Integer>
{

}
