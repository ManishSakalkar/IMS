package insurance.util;

import org.springframework.stereotype.Component;


import insurance.model.Customer;

@Component
public class CustomerUtil {

	public void mapToActualObject(Customer actual, Customer customer) {
		if(customer.getName()!=null)
			actual.setName(customer.getName());
		actual.setMobilenumber(customer.getMobilenumber());
		actual.setGender(customer.getGender());
		actual.setUsern(customer.getUsern());
		actual.setPassword(customer.getPassword());
		if(customer.getEmail()!=null)
			actual.setEmail(customer.getEmail());
		actual.setAddr(customer.getAddr());
	}

}
