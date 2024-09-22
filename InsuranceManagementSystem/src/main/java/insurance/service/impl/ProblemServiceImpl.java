package insurance.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import insurance.model.Problem;
import insurance.repo.ProblemRepository;
import insurance.service.IProblemServices;

@Service
public class ProblemServiceImpl implements IProblemServices {

	@Autowired
	private ProblemRepository repo;
	
	@Override
	public Integer saveProblem(Problem s) {
		s = repo.save(s);
		return s.getId();
	}

	@Override
	public void updateProblem(Problem s) {
		repo.save(s);
	}

	@Override
	public void deleteProblem(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Problem> getOneProblem(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Problem> getAllProblems() {
		return repo.findAll();
	}

	@Override
	public boolean isProblemExist(Integer id) {
		return repo.existsById(id);
	}

	
}
