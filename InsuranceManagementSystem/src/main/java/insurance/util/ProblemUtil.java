package insurance.util;

import org.springframework.stereotype.Component;


import insurance.model.Problem;

@Component
public class ProblemUtil {

	public void mapToActualObject(Problem actual, Problem problem) {
		if(problem.getProblemname()!=null)
			actual.setProblemname(problem.getProblemname());
			actual.setMessage(problem.getMessage());
			if(problem.getTodayd()!=null)
			actual.setTodayd(problem.getTodayd());
				
	}

}
