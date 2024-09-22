package insurance.util;

import org.springframework.stereotype.Component;


import insurance.model.Manishapp;

@Component
public class ManishappUtil {

	public void mapToActualObject(Manishapp actual, Manishapp manishapp) {
		if(manishapp.getPolicynamea()!=null)
			actual.setPolicynamea(manishapp.getPolicynamea());
			if(manishapp.getCreationa()!=null)
			actual.setCreationa(manishapp.getCreationa());
			actual.setAmounta(manishapp.getAmounta());
			actual.setInteresta(manishapp.getInteresta());
			actual.setSuma(manishapp.getSuma());
	}

}
