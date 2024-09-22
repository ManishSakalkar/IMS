package insurance.util;

import org.springframework.stereotype.Component;


import insurance.model.Manish;

@Component
public class ManishUtil {

	public void mapToActualObject(Manish actual, Manish manish) {
		if(manish.getPolicyname()!=null)
			actual.setPolicyname(manish.getPolicyname());
			if(manish.getCreation()!=null)
			actual.setCreation(manish.getCreation());
			actual.setAmount(manish.getAmount());
			actual.setInterest(manish.getInterest());
			actual.setSum(manish.getSum());
	}

}
