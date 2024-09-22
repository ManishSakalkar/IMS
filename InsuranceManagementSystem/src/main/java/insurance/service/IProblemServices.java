package insurance.service;

import java.util.List;
import java.util.Optional;

import insurance.model.Problem;

public interface IProblemServices {

	Integer saveProblem(Problem s);
	void updateProblem(Problem s);
	
	void deleteProblem(Integer id);

	Optional<Problem> getOneProblem(Integer id);
	List<Problem> getAllProblems();

	boolean isProblemExist(Integer id);
}
